package com.cloudurable.kafka.examples.UserExample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * Created by duu19572 on 22/10/2018.
 */
public class UserDeserializer implements Deserializer<User> {

    @Override public void configure (Map<String, ?> arg0, boolean arg1) {

    }

    @Override public User deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {
            user = mapper.readValue(arg1, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override public void close() {

    }
}
