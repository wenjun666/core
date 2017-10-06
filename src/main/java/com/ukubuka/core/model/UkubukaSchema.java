package com.ukubuka.core.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ukubuka Schema Model
 * 
 * @author agrawroh
 * @version v1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UkubukaSchema {

    @JsonProperty("extract")
    private List<Extract> extracts;

    @JsonProperty("transform")
    private List<Transform> transforms;

    @JsonProperty("load")
    private Load loads;

    /**
     * Extract
     * 
     * @author agrawroh
     * @version v1.0
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Extract {
        @JsonProperty("id")
        private String id;

        @JsonProperty("type")
        private SupportedFileType type;

        @JsonProperty("location")
        private String location;

        @JsonProperty("flags")
        private Map<String, Object> flags;

        /**
         * @return the type
         */
        public SupportedFileType getType() {
            return type;
        }

        /**
         * @param type
         *            the type to set
         */
        public void setType(SupportedFileType type) {
            this.type = type;
        }

        /**
         * @return the location
         */
        public String getLocation() {
            return location;
        }

        /**
         * @param location
         *            the location to set
         */
        public void setLocation(String location) {
            this.location = location;
        }

        /**
         * @return the flags
         */
        public Map<String, Object> getFlags() {
            return flags;
        }

        /**
         * @param flags
         *            the flags to set
         */
        public void setFlags(Map<String, Object> flags) {
            this.flags = flags;
        }

        /**
         * @return the id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id
         *            the id to set
         */
        public void setId(String id) {
            this.id = id;
        }
    }

    /**
     * Transform
     * 
     * @author agrawroh
     * @version v1.0
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Transform {
        @JsonProperty("id")
        private String id;

        @JsonProperty("operations")
        private List<TransformOperations> operations;

        /**
         * @return the id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id
         *            the id to set
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return the operations
         */
        public List<TransformOperations> getOperations() {
            return operations;
        }

        /**
         * @param operations
         *            the operations to set
         */
        public void setOperations(List<TransformOperations> operations) {
            this.operations = operations;
        }
    }

    /**
     * Transform Operations
     * 
     * @author agrawroh
     * @version v1.0
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TransformOperations {
        @JsonProperty("type")
        private TransformOperation type;

        @JsonProperty("source")
        private String source;

        @JsonProperty("target")
        private String target;

        /**
         * @return the source
         */
        public String getSource() {
            return source;
        }

        /**
         * @param source
         *            the source to set
         */
        public void setSource(String source) {
            this.source = source;
        }

        /**
         * @return the target
         */
        public String getTarget() {
            return target;
        }

        /**
         * @param target
         *            the target to set
         */
        public void setTarget(String target) {
            this.target = target;
        }

        /**
         * @return the type
         */
        public TransformOperation getType() {
            return type;
        }

        /**
         * @param type
         *            the type to set
         */
        public void setType(TransformOperation type) {
            this.type = type;
        }
    }

    /**
     * Load
     * 
     * @author agrawroh
     * @version v1.0
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Load {
        @JsonProperty("id")
        private String id;

        @JsonProperty("type")
        private SupportedFileType type;

        @JsonProperty("location")
        private String location;

        @JsonProperty("operations")
        private LoadOperations operations;

        /**
         * @return the id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id
         *            the id to set
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return the operations
         */
        public LoadOperations getOperations() {
            return operations;
        }

        /**
         * @param operations
         *            the operations to set
         */
        public void setOperations(LoadOperations operations) {
            this.operations = operations;
        }

        /**
         * @return the location
         */
        public String getLocation() {
            return location;
        }

        /**
         * @param location
         *            the location to set
         */
        public void setLocation(String location) {
            this.location = location;
        }

        /**
         * @return the type
         */
        public SupportedFileType getType() {
            return type;
        }

        /**
         * @param type
         *            the type to set
         */
        public void setType(SupportedFileType type) {
            this.type = type;
        }
    }

    /**
     * Load Operations
     * 
     * @author agrawroh
     * @version v1.0
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LoadOperations {
        @JsonProperty("type")
        private LoadOperation type;

        @JsonProperty("header")
        private String header;

        @JsonProperty("data")
        private List<String> data;

        @JsonProperty("filter")
        private String filter;

        /**
         * @return the type
         */
        public LoadOperation getType() {
            return type;
        }

        /**
         * @param type
         *            the type to set
         */
        public void setType(LoadOperation type) {
            this.type = type;
        }

        /**
         * @return the filter
         */
        public String getFilter() {
            return filter;
        }

        /**
         * @param filter
         *            the filter to set
         */
        public void setFilter(String filter) {
            this.filter = filter;
        }

        /**
         * @return the header
         */
        public String getHeader() {
            return header;
        }

        /**
         * @param header
         *            the header to set
         */
        public void setHeader(String header) {
            this.header = header;
        }

        /**
         * @return the data
         */
        public List<String> getData() {
            return data;
        }

        /**
         * @param data
         *            the data to set
         */
        public void setData(List<String> data) {
            this.data = data;
        }
    }

    /**
     * @return the extracts
     */
    public List<Extract> getExtracts() {
        return extracts;
    }

    /**
     * @param extracts
     *            the extracts to set
     */
    public void setExtracts(List<Extract> extracts) {
        this.extracts = extracts;
    }

    /**
     * @return the transforms
     */
    public List<Transform> getTransforms() {
        return transforms;
    }

    /**
     * @param transforms
     *            the transforms to set
     */
    public void setTransforms(List<Transform> transforms) {
        this.transforms = transforms;
    }

    /**
     * @return the loads
     */
    public Load getLoads() {
        return loads;
    }

    /**
     * @param loads
     *            the loads to set
     */
    public void setLoads(Load loads) {
        this.loads = loads;
    }
}
