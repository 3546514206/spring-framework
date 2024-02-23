/*
 * Copyright 2002-2014 the original author or authors.
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

package org.springframework.context;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.lang.Nullable;

/**
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 *
 * <p>An ApplicationContext provides:
 * <ul>
 * <li>Bean factory methods for accessing application components.
 * Inherited from {@link org.springframework.beans.factory.ListableBeanFactory}.
 * <li>The ability to load file resources in a generic fashion.
 * Inherited from the {@link org.springframework.core.io.ResourceLoader} interface.
 * <li>The ability to publish events to registered listeners.
 * Inherited from the {@link ApplicationEventPublisher} interface.
 * <li>The ability to resolve messages, supporting internationalization.
 * Inherited from the {@link MessageSource} interface.
 * <li>Inheritance from a parent context. Definitions in a descendant context
 * will always take priority. This means, for example, that a single parent
 * context can be used by an entire web application, while each servlet has
 * its own child context that is independent of that of any other servlet.
 * </ul>
 *
 * <p>In addition to standard {@link org.springframework.beans.factory.BeanFactory}
 * lifecycle capabilities, ApplicationContext implementations detect and invoke
 * {@link ApplicationContextAware} beans as well as {@link ResourceLoaderAware},
 * {@link ApplicationEventPublisherAware} and {@link MessageSourceAware} beans.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author
 * @see org.springframework.context.ConfigurableApplicationContext
 * @see org.springframework.beans.factory.BeanFactory
 * @see org.springframework.core.io.ResourceLoader
 * <p>
 * 在 Spring IoC 容器的设计中，我们可以看到两个主要的容器系列，一个是实现 BeanFactory 接口的简单容器系列，
 * 这系列的容器只实现了容器的最基本功能；另外一个是 ApplicationContext 应用上下文，它作为容器的高级形态而存在。应用
 * 上下文在简单容器的基础之上，增加了很多面向框架的特性，同时对应用环境做了很多适配。有了这两种基本的容器系列，基本上可以满足用户对 IoC
 * 容器的大部分需求了。
 * <p>
 * BeanFactory -> ListableBeanFactory -> ApplicationContext 是容器的一条主要接口设计路线
 * 从 ApplicationContext 到 ConfigurableApplicationContext 或者 WebApplicationContext 就是我们常用的应用上下文的基本实现。
 * 在以上接口继承体系中，ListableBeanFactory 和 HierarchicalBeanFactory 两个接口，连接了 BeanFactory 接口定义和
 * ApplicationContext 应用上下文的接口定义。在 ListableBeanFactory 接口中，细化了许多 BeanFactory 接口的许多接口功能，比如定义了
 * getBeanDefinitionNames 方法；在 HierarchicalBeanFactory 接口中，则通过定义 getParentBeanFactory 方法使得当前容器具备了获
 * 取双亲容器的功能。而对于 ApplicationContext 接口，通过继承 MessageSource、ApplicationEventPublisher、ResourcePatternResolver等
 * 接口，在 BeanFactory 简单 IoC 容器的基础之上添加了许多对高级容器的特性的支持。
 */

/**
 * 在 Spring IoC 容器的设计中，我们可以看到两个主要的容器系列，一个是实现 BeanFactory 接口的简单容器系列，
 * 这系列的容器只实现了容器的最基本功能；另外一个是 ApplicationContext 应用上下文，它作为容器的高级形态而存在。应用
 * 上下文在简单容器的基础之上，增加了很多面向框架的特性，同时对应用环境做了很多适配。有了这两种基本的容器系列，基本上可以满足用户对 IoC
 * 容器的大部分需求了。
 * <p>
 * BeanFactory -> ListableBeanFactory -> ApplicationContext 是容器的一条主要接口设计路线
 * 从 ApplicationContext 到 ConfigurableApplicationContext 或者 WebApplicationContext 就是我们常用的应用上下文的基本实现。
 * 在以上接口继承体系中，ListableBeanFactory 和 HierarchicalBeanFactory 两个接口，连接了 BeanFactory 接口定义和
 * ApplicationContext 应用上下文的接口定义。在 ListableBeanFactory 接口中，细化了许多 BeanFactory 接口的许多接口功能，比如定义了
 * getBeanDefinitionNames 方法；在 HierarchicalBeanFactory 接口中，则通过定义 getParentBeanFactory 方法使得当前容器具备了获
 * 取双亲容器的功能。而对于 ApplicationContext 接口，通过继承 MessageSource、ApplicationEventPublisher、ResourcePatternResolver等
 * 接口，在 BeanFactory 简单 IoC 容器的基础之上添加了许多对高级容器的特性的支持。
 *
 * @author BeanFactory -> ListableBeanFactory -> ApplicationContext 是容器的一条主要接口设计路线
 * 从 ApplicationContext 到 ConfigurableApplicationContext 或者 WebApplicationContext 就是我们常用的应用上下文的基本实现。
 * 在以上接口继承体系中，ListableBeanFactory 和 HierarchicalBeanFactory 两个接口，连接了 BeanFactory 接口定义和
 * ApplicationContext 应用上下文的接口定义。在 ListableBeanFactory 接口中，细化了许多 BeanFactory 接口的许多接口功能，比如定义了
 * getBeanDefinitionNames 方法；在 HierarchicalBeanFactory 接口中，则通过定义 getParentBeanFactory 方法使得当前容器具备了获
 * 取双亲容器的功能。而对于 ApplicationContext 接口，通过继承 MessageSource、ApplicationEventPublisher、ResourcePatternResolver等
 * 接口，在 BeanFactory 简单 IoC 容器的基础之上添加了许多对高级容器的特性的支持。
 * @author
 */

/**
 * BeanFactory -> ListableBeanFactory -> ApplicationContext 是容器的一条主要接口设计路线
 * 从 ApplicationContext 到 ConfigurableApplicationContext 或者 WebApplicationContext 就是我们常用的应用上下文的基本实现。
 * 在以上接口继承体系中，ListableBeanFactory 和 HierarchicalBeanFactory 两个接口，连接了 BeanFactory 接口定义和
 * ApplicationContext 应用上下文的接口定义。在 ListableBeanFactory 接口中，细化了许多 BeanFactory 接口的许多接口功能，比如定义了
 * getBeanDefinitionNames 方法；在 HierarchicalBeanFactory 接口中，则通过定义 getParentBeanFactory 方法使得当前容器具备了获
 * 取双亲容器的功能。而对于 ApplicationContext 接口，通过继承 MessageSource、ApplicationEventPublisher、ResourcePatternResolver等
 * 接口，在 BeanFactory 简单 IoC 容器的基础之上添加了许多对高级容器的特性的支持。
 *
 * @author
 */

/**
 * ApplicationContext 作为 IoC 容器的高级形态，从接口设计上看，具备了 BeanFactory 不具备的这些特性：
 * 1、首先是国际化支持。ApplicationContext 集成了MessageSource接口，这使得我们的容器可以支持国际化功能，
 * 为需要开发出多语言版本的应用提供服务。
 * 2、不同资源访问bean信息。这一特性主要是体现在 ResourcePatternResolver（ResourceLoader、Resource）的
 * 接口设计上。这使得我们可以通过不同的路径获取bean定义的信息。
 * 3、支持应用事件。继承了接口 ApplicationEventPublisher，从而在应用上下文中引入了事件机制。事件机制和 bean 的
 * 生命周期结合为 bean 的管理提供了便利。
 *
 *
 */
public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,
		MessageSource, ApplicationEventPublisher, ResourcePatternResolver {

	/**
	 * Return the unique id of this application context.
	 * @return the unique id of the context, or {@code null} if none
	 */
	@Nullable
	String getId();

	/**
	 * Return a name for the deployed application that this context belongs to.
	 * @return a name for the deployed application, or the empty String by default
	 */
	String getApplicationName();

	/**
	 * Return a friendly name for this context.
	 * @return a display name for this context (never {@code null})
	 */
	String getDisplayName();

	/**
	 * Return the timestamp when this context was first loaded.
	 * @return the timestamp (ms) when this context was first loaded
	 */
	long getStartupDate();

	/**
	 * Return the parent context, or {@code null} if there is no parent
	 * and this is the root of the context hierarchy.
	 * @return the parent context, or {@code null} if there is no parent
	 */
	@Nullable
	ApplicationContext getParent();

	/**
	 * Expose AutowireCapableBeanFactory functionality for this context.
	 * <p>This is not typically used by application code, except for the purpose of
	 * initializing bean instances that live outside of the application context,
	 * applying the Spring bean lifecycle (fully or partly) to them.
	 * <p>Alternatively, the internal BeanFactory exposed by the
	 * {@link ConfigurableApplicationContext} interface offers access to the
	 * {@link AutowireCapableBeanFactory} interface too. The present method mainly
	 * serves as a convenient, specific facility on the ApplicationContext interface.
	 * <p><b>NOTE: As of 4.2, this method will consistently throw IllegalStateException
	 * after the application context has been closed.</b> In current Spring Framework
	 * versions, only refreshable application contexts behave that way; as of 4.2,
	 * all application context implementations will be required to comply.
	 * @return the AutowireCapableBeanFactory for this context
	 * @throws IllegalStateException if the context does not support the
	 * {@link AutowireCapableBeanFactory} interface, or does not hold an
	 * autowire-capable bean factory yet (e.g. if {@code refresh()} has
	 * never been called), or if the context has been closed already
	 * @see ConfigurableApplicationContext#refresh()
	 * @see ConfigurableApplicationContext#getBeanFactory()
	 */
	AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException;

}
