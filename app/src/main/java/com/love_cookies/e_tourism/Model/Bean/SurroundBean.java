package com.love_cookies.e_tourism.Model.Bean;

import java.util.List;

/**
 * Created by xiekun on 2016/4/12.
 *
 * 周边实体类
 */
public class SurroundBean {

    /**
     * status : OK
     * results : [{"name":"全季酒店(虹桥店)","location":{"lat":31.202978,"lng":121.412444},"address":"上海市长宁区伊犁南路566号(伊犁南路与虹桥路交叉口)","telephone":"(021)32560666","uid":"7ff79d8c9a5a73b2704b87ae","tag":"古北;虹桥 连锁酒店","detail_url":"http://api.map.baidu.com/place/detail?uid=7ff79d8c9a5a73b2704b87ae&output=html&source=placeapi"},{"name":"古北湾大酒店","location":{"lat":31.20487,"lng":121.408569},"address":"上海市长宁区虹桥路1446号（近世贸商城）","telephone":"(021)52574888","uid":"75d0881a9e7839543a04b119","tag":"古北;虹桥 宾馆","detail_url":"http://api.map.baidu.com/place/detail?uid=75d0881a9e7839543a04b119&output=html&source=placeapi"}]
     */
    private String status;

    /**
     * name : 全季酒店(虹桥店)
     * location : {"lat":31.202978,"lng":121.412444}
     * address : 上海市长宁区伊犁南路566号(伊犁南路与虹桥路交叉口)
     * telephone : (021)32560666
     * uid : 7ff79d8c9a5a73b2704b87ae
     * tag : 古北;虹桥 连锁酒店
     * detail_url : http://api.map.baidu.com/place/detail?uid=7ff79d8c9a5a73b2704b87ae&output=html&source=placeapi
     */
    private List<ResultsBean> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String name;

        /**
         * lat : 31.202978
         * lng : 121.412444
         */
        private LocationBean location;
        private String address;
        private String telephone;
        private String uid;
        private String tag;
        private String detail_url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getDetail_url() {
            return detail_url;
        }

        public void setDetail_url(String detail_url) {
            this.detail_url = detail_url;
        }

        public static class LocationBean {
            private double lat;
            private double lng;

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }
        }
    }
}
