# Demo Rest CXF con Swagger
[Swagger](https://swagger.io/) permite documentar webservice REST.

Este proyecto toma como base [Demo Rest CXF](../demo-rest), con solo agregar la dependencia 

```
    <dependency>
        <groupId>org.apache.cxf</groupId>
        <artifactId>cxf-rt-rs-service-description-swagger</artifactId>
        <version>3.1.11</version>
    </dependency>
```

y agregar al servicio en el blueprint el feature 

```
    <jaxrs:server id="helloService" address="/helloSwagger">
        ...
        <jaxrs:features>
            <bean id="swagger2Feature" class="org.apache.cxf.jaxrs.swagger.Swagger2Feature">
                <property name="basePath" value="/cxf/helloSwagger"/>
                <property name="prettyPrint" value="true" />
            </bean>
        </jaxrs:features>
    </jaxrs:server>
```

ya tenemos disponible la documentación en el path del servicio agregando al final `swagger.json`

Para este demo la url es `http://localhost:8181/cxf/helloSwagger/swagger.json`

Hay una serie de propiedades que se pueden especificar en el blueprint para cambiar lo que se muestra, las cuales se pueden consultar en http://cxf.apache.org/docs/swagger2feature.html

En el código se pueden agregar anotaciones para indicar el uso, valores que se reciben, códigos de retorno.

Las anotaciones disponibles se pueden ver en https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X

