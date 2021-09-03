package com.tandy.redislecturetest;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.protocol.CommandType;
import io.lettuce.core.output.StatusOutput;
import io.lettuce.core.protocol.CommandArgs;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;

public class TestLettuce {
    public static void main(String[] args){
        RedisURI redisUri = RedisURI.builder().withHost("119.29.26.75").withPort(10004).withPassword("suiteng1234").build();
//        RedisURI redisUri = RedisURI.builder().withHost("106.52.79.188").withPort(30088).withPassword("suiteng1234").build();
        RedisClient clusterClient = RedisClient.create(redisUri);
        StatefulRedisConnection<String, String> connection = clusterClient.connect();
        RedisCommands<String, String> sync = connection.sync();
        RedisCodec<String, String> codec = StringCodec.UTF8;
        String result = sync.dispatch(CommandType.SET, new StatusOutput<>(codec), new CommandArgs<>(codec).addKey("aa").addValue("9a1ad96c9b49d3ea1e39014bf78ef3bbe47fd921"));
        System.out.println(result);
        String result2 = sync.dispatch(CommandType.GET, new StatusOutput<>(codec), new CommandArgs<>(codec).addKey("aa"));
        System.out.println(result2);
        connection.close();
        clusterClient.shutdown();
    }
}

