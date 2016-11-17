package com.gift.mygift.entity;

import java.util.List;

/**
 * 作者:  qiang on 2016/11/17 18:36
 * 邮箱:  anworkmail_q@126.com
 * 作用:  指南首页广告轮播
 */

public class HomeBanner {

    /**
     * ad_monitors : []
     * channel : all
     * id : 783
     * image_url : http://img01.liwushuo.com/image/161117/g3t0nm1f4.jpg-w720
     * order : 800
     * status : 0
     * target : {"banner_image_url":"http://img03.liwushuo.com/image/161116/krre8ivjw.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/161116/krre8ivjw.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/161116/ufe66a9jz.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/161116/ufe66a9jz.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1479291789,"id":392,"posts_count":6,"status":1,"subtitle":"身为实力担当，居然还能这么萌！","title":"数码萌物","updated_at":1479292023}
     * target_id : 392
     * target_type : url
     * target_url : liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=392
     * type : collection
     * webp_url : http://img01.liwushuo.com/image/161117/g3t0nm1f4.jpg?imageView2/2/w/720/q/85/format/webp
     */

    public String channel;
    public int id;
    public String image_url;
    public int order;
    public int status;
    /**
     * banner_image_url : http://img03.liwushuo.com/image/161116/krre8ivjw.jpg-w300
     * banner_webp_url : http://img03.liwushuo.com/image/161116/krre8ivjw.jpg?imageView2/2/w/300/q/85/format/webp
     * cover_image_url : http://img03.liwushuo.com/image/161116/ufe66a9jz.jpg-w720
     * cover_webp_url : http://img03.liwushuo.com/image/161116/ufe66a9jz.jpg?imageView2/2/w/720/q/85/format/webp
     * created_at : 1479291789
     * id : 392
     * posts_count : 6
     * status : 1
     * subtitle : 身为实力担当，居然还能这么萌！
     * title : 数码萌物
     * updated_at : 1479292023
     */

    public TargetBean target;
    public int target_id;
    public String target_type;
    public String target_url;
    public String type;
    public String webp_url;
    public List<String> ad_monitors;

    public static class TargetBean {
        public String banner_image_url;
        public String banner_webp_url;
        public String cover_image_url;
        public String cover_webp_url;
        public int created_at;
        public int id;
        public int posts_count;
        public int status;
        public String subtitle;
        public String title;
        public int updated_at;
    }
}
