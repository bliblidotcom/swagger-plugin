Spring Boot Swagger Plugin
--------------------------

Add this dependency in your ```pom.xml```

```xml
<repositories>
    ...
    <repository>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
      <id>bintray-bliblidotcom-maven</id>
      <name>bintray</name>
      <url>https://dl.bintray.com/bliblidotcom/maven</url>
    </repository>
    ...
</repositories>
```

```xml
<dependencies>
  ...
  <dependency>
   <groupId>com.blibli.oss</groupId>
   <artifactId>swagger-plugin</artifactId>
   <version>...</version>
 </dependency>
 ...
</dependencies>
```

To add controller to Swagger UI, add `@Api` in you controller class.
