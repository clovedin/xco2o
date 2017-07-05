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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Administrator on 2017/7/5.
 */
@Configuration
@EnableIgniteRepositories
public class CfgIgnite {

    @Bean
    public Ignite igniteInstance() {
        //配置对象
        IgniteConfiguration cfg = new IgniteConfiguration();
        //节点名
        cfg.setIgniteInstanceName("xco2oLiveNode");
        //启用对等类加载
        cfg.setPeerClassLoadingEnabled(true);

        CacheConfiguration groupInfoCfg = IgniteCacheUtils.springDataCacheCfg(Long.class, GroupInfo.class);
        cfg.setCacheConfiguration(groupInfoCfg);
        CacheConfiguration postsInfoCfg = IgniteCacheUtils.springDataCacheCfg(Long.class, PostsInfo.class);
        cfg.setCacheConfiguration(postsInfoCfg);
        CacheConfiguration postsReplyCfg = IgniteCacheUtils.springDataCacheCfg(Long.class, PostsReply.class);
        cfg.setCacheConfiguration(postsReplyCfg);

        return Ignition.start(cfg);
    }
}
