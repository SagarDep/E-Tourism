package com.love_cookies.e_tourism.Model.Bean;

/**
 * Created by xiekun on 2016/4/11.
 *
 * 地理位置实体类
 */
public class LocationBean {

    /**
     * status : OK
     * result : {"location":{"lng":118.784713,"lat":31.903248},"formatted_address":"江苏省南京市江宁区水阁路","business":"","addressComponent":{"city":"南京市","direction":"","distance":"","district":"江宁区","province":"江苏省","street":"水阁路","street_number":""},"cityCode":315}
     */

    private String status;
    /**
     * location : {"lng":118.784713,"lat":31.903248}
     * formatted_address : 江苏省南京市江宁区水阁路
     * business :
     * addressComponent : {"city":"南京市","direction":"","distance":"","district":"江宁区","province":"江苏省","street":"水阁路","street_number":""}
     * cityCode : 315
     */

    private ResultEntity result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public static class ResultEntity {
        /**
         * lng : 118.784713
         * lat : 31.903248
         */

        private LocationEntity location;
        private String formatted_address;
        private String business;
        /**
         * city : 南京市
         * direction :
         * distance :
         * district : 江宁区
         * province : 江苏省
         * street : 水阁路
         * street_number :
         */

        private AddressComponentEntity addressComponent;
        private int cityCode;

        public LocationEntity getLocation() {
            return location;
        }

        public void setLocation(LocationEntity location) {
            this.location = location;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public AddressComponentEntity getAddressComponent() {
            return addressComponent;
        }

        public void setAddressComponent(AddressComponentEntity addressComponent) {
            this.addressComponent = addressComponent;
        }

        public int getCityCode() {
            return cityCode;
        }

        public void setCityCode(int cityCode) {
            this.cityCode = cityCode;
        }

        public static class LocationEntity {
            private double lng;
            private double lat;

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }

        public static class AddressComponentEntity {
            private String city;
            private String direction;
            private String distance;
            private String district;
            private String province;
            private String street;
            private String street_number;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }
        }
    }
}
