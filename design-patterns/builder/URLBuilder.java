/*
What is the Builder Pattern?
The Builder Pattern helps you create complex objects step-by-step, without having to pass a huge constructor with many parameters.
When do we use it?
When an object has many optional fields
When an object is complex to construct
When you want readable object creation (fluent style)
*/

class URLBuilder {
    private String protocol;
    private String domain;
    private String path;
    private String query;

    private URLBuilder(Builder builder) {
        this.protocol = builder.protocol;
        this.domain = builder.domain;
        this.path = builder.path;
        this.query = builder.query;
    }

    public String build() {
        StringBuilder url = new StringBuilder();
        url.append(protocol).append("://").append(domain);

        if (path != null && !path.isEmpty()) {
            url.append("/").append(path);
        }

        if (query != null && !query.isEmpty()) {
            url.append("?").append(query);
        }

        return url.toString();
    }

    // Builder
    public static class Builder {
        private String protocol = "https";
        private String domain;
        private String path;
        private String query;

        public Builder setProtocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder setDomain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public Builder setQuery(String query) {
            this.query = query;
            return this;
        }

        public URLBuilder build() {
            return new URLBuilder(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static void main(String[] args) {
        String url = URLBuilder.builder()
                .setProtocol("https")
                .setDomain("example.com")
                .setPath("products")
                .setQuery("id=10&sort=asc")
                .build()
                .build(); // get final URL string

        System.out.println(url);
    }
}

