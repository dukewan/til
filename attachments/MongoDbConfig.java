package com.expedia.www.yihe.sortrankalert.config;

import com.expedia.www.yihe.sortrankalert.model.MongoServer;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "mongodb", ignoreUnknownFields = false)
@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableMongoRepositories("com.expedia.www.yihe.sortrankalert.repository")
public class MongoDbConfig extends AbstractMongoConfiguration{
    private List<MongoServer> servers;

    private Map<String, String> dbNames;

    private MongoClient mongoClient;

    public List<MongoServer> getServers() {
        return servers;
    }

    public void setServers(List<MongoServer> servers) {
        this.servers = servers;
    }

    public Map<String, String> getDbNames() {
        return dbNames;
    }

    public void setDbNames(Map<String, String> dbNames) {
        this.dbNames = dbNames;
    }

    @Override
    @Bean
    public Mongo mongo() throws UnknownHostException {
        return null == mongoClient ? createMongoClient(getServerAddresses()) : mongoClient;
    }

    @Override
    public String getDatabaseName() {
        return dbNames.get("sortRankDB");
    }

    protected MongoClient createMongoClient(List<ServerAddress> servers) {
        return new MongoClient(servers);
    }

    private List<ServerAddress> getServerAddresses() throws UnknownHostException {
        final List<ServerAddress> serverAddressList = new ArrayList<>();
        for (final MongoServer server : getServers()) {
            serverAddressList.add(new ServerAddress(server.getHost(), server.getPort()));
        }
        return serverAddressList;
    }
}
