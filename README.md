스프링 프로젝트 생성

기본설정 : Window > Preferences > General >Workspace > Text file encoding > other:utf-8
		      	    > Wed > encoding utf-8로 바꾸기

1. File > New > Spring Legacy Project

Project name > Spring MVC Project선택 > next > package(org.conan.controller)

2. 프로젝트 > properties > project facts >dynamic web module 4.0 /java 11

3. pom.xml 추가(자바버전 일치)

4. 서버 추가( tomcat v9.0)
- Servers > server.xml > GlobalNamingResources 디비경로추가

      <Resource driverClassName="com.mysql.cj.jdbc.Driver" maxActive="10" maxIdle="4" maxWait="5000" name="jdbc/myoracle" password="tiger" type="javax.sql.DataSource" url="jdbc:mysql://localhost:3306/scottdb?useSSL=false&amp;allowPublicKeyRetrieval=true" username="scott"/> 
	
- Servers > context.xml > 마지막부분에 추가

      <ResourceLink global="jdbc/myoracle" name="jdbc/myoracle" type="javax.sql.DataSource"/>

 5. root-context.xml > <bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
         
         <property name="driverClassName"
            value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"></property>
          <property name="jdbcUrl"
            value="jdbc:log4jdbc:mysql://localhost:3306/scottdb?useSSL=false"></property>
          <property name="username" value="scott"></property>
          <property name="password" value="tiger"></property>

		<!-- HikariCP configuration -->
		<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource"
			destroy-method="close">
			<constructor-arg ref="hikariConfig"></constructor-arg>
		</bean>

		*mybatis 연동*

		<bean id="sqlSessionFactory"
		class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"></property>
		</bean>

* root-context.xml
	
	<context:component-scan base-package="org.conan.*"></context:component-scan> 
	<mybatis-spring:scan base-package="org.conan.controller" /> ---> xml처리하는 파일패키지로

* servlet-context.xml
	
	<context:component-scan base-package="org.conan.*" />

