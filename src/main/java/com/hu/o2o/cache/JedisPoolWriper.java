package com.hu.o2o.cache;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolWriper {
    private JedisPool jedisPool;

    public JedisPoolWriper(final JedisPoolConfig poolConfig, final String host,
                           final int port) {
        jedisPool = new JedisPool(poolConfig, host, port);

    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}
