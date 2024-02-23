/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.http.codec.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.core.ResolvableType;
import org.springframework.core.codec.AbstractDecoderTests;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.codec.Pojo;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.util.MimeType;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.core.ResolvableType.forClass;
import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Unit tests for {@link Jackson2SmileDecoder}.
 *
 * @author Sebastien Deleuze
 */
public class Jackson2SmileDecoderTests extends AbstractDecoderTests<Jackson2SmileDecoder> {

	private final static MimeType SMILE_MIME_TYPE = new MimeType("application", "x-jackson-smile");
	private final static MimeType STREAM_SMILE_MIME_TYPE = new MimeType("application", "stream+x-jackson-smile");

	private Pojo pojo1 = new Pojo("f1", "b1");

	private Pojo pojo2 = new Pojo("f2", "b2");

	private ObjectMapper mapper = Jackson2ObjectMapperBuilder.smile().build();

	public Jackson2SmileDecoderTests() {
		super(new Jackson2SmileDecoder());
	}

	@Override
	@Test
	public void canDecode() {
		assertThat(decoder.canDecode(forClass(Pojo.class), SMILE_MIME_TYPE)).isTrue();
		assertThat(decoder.canDecode(forClass(Pojo.class), STREAM_SMILE_MIME_TYPE)).isTrue();
		assertThat(decoder.canDecode(forClass(Pojo.class), null)).isTrue();

		assertThat(decoder.canDecode(forClass(String.class), null)).isFalse();
		assertThat(decoder.canDecode(forClass(Pojo.class), APPLICATION_JSON)).isFalse();
	}

	@Override
	@Test
	public void decode() {
		Flux<DataBuffer> input = Flux.just(this.pojo1, this.pojo2)
				.map(this::writeObject)
				.flatMap(this::dataBuffer);

		testDecodeAll(input, Pojo.class, step -> step
				.expectNext(pojo1)
				.expectNext(pojo2)
				.verifyComplete());

	}

	private byte[] writeObject(Object o) {
		try {
			return this.mapper.writer().writeValueAsBytes(o);
		}
		catch (JsonProcessingException e) {
			throw new AssertionError(e);
		}

	}

	@Override
	@Test
	public void decodeToMono() {
		List<Pojo> expected = Arrays.asList(pojo1, pojo2);

		Flux<DataBuffer> input = Flux.just(expected)
				.map(this::writeObject)
				.flatMap(this::dataBuffer);

		ResolvableType elementType = ResolvableType.forClassWithGenerics(List.class, Pojo.class);
		testDecodeToMono(input, elementType, step -> step
				.expectNext(expected)
				.expectComplete()
				.verify(), null, null);
	}

}
