package com.zerofiltre.stackoverflow.q_66645119_5615357_mongodbtest;

import com.mongodb.client.MongoClients;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@TestMethodOrder(OrderAnnotation.class)
class IntegrationTests {

  private static final String CONNECTION_STRING = "mongodb://%s:%d";

  @BeforeAll
  static void setup() throws Exception {
    String ip = "localhost";
    int port = 65000;

    IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
        .net(new Net(ip, port, Network.localhostIsIPv6())).build();

    MongodStarter starter = MongodStarter.getDefaultInstance();
    MongodExecutable mongodExecutable = starter.prepare(mongodConfig);
    mongodExecutable.start();

    MongoTemplate mongoTemplate = new MongoTemplate(MongoClients.create(String.format(CONNECTION_STRING, ip, port)),
        "test");
  }

  @Test
  public void embeddedMongoDbLoads() {

  }
}

