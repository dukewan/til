# Configuration and Retrieve info

+ Use application.yml to store the configuration infos
+ eg: mongodb config in application.yml:
```yml
mongodb:
    # list of all servers in the mongo cluster (one line per server)
    servers:
        - {host: 10.2.13.8, port: 27017}
    dbNames:
        sortRankDB: epcstore
```
+ Use below to retrieve the configurations and reflection to Java classes:
```java
@Configuration
@ConfigurationProperties(prefix = "mongodb", ignoreUnknownFields = false)
@EnableConfigurationProperties
@EnableAutoConfiguration
```
