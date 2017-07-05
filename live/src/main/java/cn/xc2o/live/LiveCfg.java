package cn.xc2o.live;

import cn.xc2o.live.entity.GroupInfo;
import cn.xc2o.live.entity.PostsInfo;
import cn.xc2o.live.entity.PostsReply;
import cn.xc2o.live.utils.IgniteCacheUtils;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by cc on 2017/7/3.
 */
@Configuration
@EnableWebMvc
public class LiveCfg {



}
