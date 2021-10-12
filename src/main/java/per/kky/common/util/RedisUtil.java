package per.kky.common.util;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, String value, Duration time) {
        if(TimeoutUtils.hasMillis(time)) {
            redisTemplate.opsForValue().set(key, value, time.toMillis(), TimeUnit.MILLISECONDS);
        } else {
            redisTemplate.opsForValue().set(key, value, time.getSeconds(), TimeUnit.SECONDS);
        }
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
