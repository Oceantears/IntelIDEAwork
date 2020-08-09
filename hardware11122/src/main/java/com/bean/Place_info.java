package com.bean;

import java.util.Date;

    public class Place_info {
        private Integer id;
        private Integer company_id;
        private String place_title;
        private String place_address;
        private String place_content;
        private Integer company_user;
        private Date add_time;
        private String service_province;
        private String service_city;
        private String service_county;
        private Double jingdu;
        private Double weidu;
        private String fengmian_picture;

        @Override
        public String toString() {
            return "Place_info{" +
                    "id=" + id +
                    ", company_id=" + company_id +
                    ", place_title='" + place_title + '\'' +
                    ", place_address='" + place_address + '\'' +
                    ", place_content='" + place_content + '\'' +
                    ", company_user=" + company_user +
                    ", add_time=" + add_time +
                    ", service_province='" + service_province + '\'' +
                    ", service_city='" + service_city + '\'' +
                    ", service_county='" + service_county + '\'' +
                    ", jingdu=" + jingdu +
                    ", weidu=" + weidu +
                    ", fengmian_picture='" + fengmian_picture + '\'' +
                    '}';
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCompany_id() {
            return company_id;
        }

        public void setCompany_id(Integer company_id) {
            this.company_id = company_id;
        }

        public String getPlace_title() {
            return place_title;
        }

        public void setPlace_title(String place_title) {
            this.place_title = place_title;
        }

        public String getPlace_address() {
            return place_address;
        }

        public void setPlace_address(String place_address) {
            this.place_address = place_address;
        }

        public String getPlace_content() {
            return place_content;
        }

        public void setPlace_content(String place_content) {
            this.place_content = place_content;
        }

        public Integer getCompany_user() {
            return company_user;
        }

        public void setCompany_user(Integer company_user) {
            this.company_user = company_user;
        }

        public Date getAdd_time() {
            return add_time;
        }

        public void setAdd_time(Date add_time) {
            this.add_time = add_time;
        }

        public String getService_province() {
            return service_province;
        }

        public void setService_province(String service_province) {
            this.service_province = service_province;
        }

        public String getService_city() {
            return service_city;
        }

        public void setService_city(String service_city) {
            this.service_city = service_city;
        }

        public String getService_county() {
            return service_county;
        }

        public void setService_county(String service_county) {
            this.service_county = service_county;
        }

        public Double getJingdu() {
            return jingdu;
        }

        public void setJingdu(Double jingdu) {
            this.jingdu = jingdu;
        }

        public Double getWeidu() {
            return weidu;
        }

        public void setWeidu(Double weidu) {
            this.weidu = weidu;
        }

        public String getFengmian_picture() {
            return fengmian_picture;
        }

        public void setFengmian_picture(String fengmian_picture) {
            this.fengmian_picture = fengmian_picture;
        }


}
