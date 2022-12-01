import java.util.ArrayList;

public class Authentication {

    public class Data {
        private String _id;
        private String code;
        private String phone;
        private String role;
        private boolean active;
        private boolean phone_verified;
        private boolean email_verified;
        private String photo = null;
        private String city = null;
        private String state = null;
        private String address = null;
        Following FollowingObject;
        private String default_list_id = null;
        private boolean browse_organization_as_admin;
        private String company;
        private float tickets_count;
        private float cards_count;
        private String gamified_campaign_id = null;
        private boolean is_anonymous;
        private String country_name = null;
        private String key_managed_by;
        Source SourceObject;
        private String first_name;
        private String last_name;
        private String email;
        private String country;
        private String created_at;
        private String updated_at;
        private String full_name;
        private float __v;
        private String wallet_address;
        private String country_id = null;
        Solana_address Solana_addressObject;

        ArrayList < Object > memberships = new ArrayList < Object > ();
        private String crypto_nonce;
        Crypto_wallet Crypto_walletObject;
        private String id;
        ArrayList < Object > active_crypto_wallets = new ArrayList < Object > ();
        private String api_token;
        private float api_token_expires_in;
        private String default_payment_method = null;
        private float transaction_count;
        ArrayList < Object > invitations = new ArrayList < Object > ();
        private float bids_count;
        private boolean has_winnings;


        // Getter Methods

        public String get_id() {
            return _id;
        }

        public String getCode() {
            return code;
        }

        public String getPhone() {
            return phone;
        }

        public String getRole() {
            return role;
        }

        public boolean getActive() {
            return active;
        }

        public boolean getPhone_verified() {
            return phone_verified;
        }

        public boolean getEmail_verified() {
            return email_verified;
        }

        public String getPhoto() {
            return photo;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getAddress() {
            return address;
        }

        public Following getFollowing() {
            return FollowingObject;
        }

        public String getDefault_list_id() {
            return default_list_id;
        }

        public boolean getBrowse_organization_as_admin() {
            return browse_organization_as_admin;
        }

        public String getCompany() {
            return company;
        }

        public float getTickets_count() {
            return tickets_count;
        }

        public float getCards_count() {
            return cards_count;
        }

        public String getGamified_campaign_id() {
            return gamified_campaign_id;
        }

        public boolean getIs_anonymous() {
            return is_anonymous;
        }

        public String getCountry_name() {
            return country_name;
        }

        public String getKey_managed_by() {
            return key_managed_by;
        }

        public Source getSource() {
            return SourceObject;
        }

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public String getEmail() {
            return email;
        }

        public String getCountry() {
            return country;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getFull_name() {
            return full_name;
        }

        public float get__v() {
            return __v;
        }

        public String getWallet_address() {
            return wallet_address;
        }

        public String getCountry_id() {
            return country_id;
        }

        public Solana_address getSolana_address() {
            return Solana_addressObject;
        }

        public String getCrypto_nonce() {
            return crypto_nonce;
        }

        public Crypto_wallet getCrypto_wallet() {
            return Crypto_walletObject;
        }

        public String getId() {
            return id;
        }

        public String getApi_token() {
            return api_token;
        }

        public float getApi_token_expires_in() {
            return api_token_expires_in;
        }

        public String getDefault_payment_method() {
            return default_payment_method;
        }

        public float getTransaction_count() {
            return transaction_count;
        }

        public float getBids_count() {
            return bids_count;
        }

        public boolean getHas_winnings() {
            return has_winnings;
        }

        // Setter Methods

        public void set_id(String _id) {
            this._id = _id;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public void setPhone_verified(boolean phone_verified) {
            this.phone_verified = phone_verified;
        }

        public void setEmail_verified(boolean email_verified) {
            this.email_verified = email_verified;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setFollowing(Following followingObject) {
            this.FollowingObject = followingObject;
        }

        public void setDefault_list_id(String default_list_id) {
            this.default_list_id = default_list_id;
        }

        public void setBrowse_organization_as_admin(boolean browse_organization_as_admin) {
            this.browse_organization_as_admin = browse_organization_as_admin;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public void setTickets_count(float tickets_count) {
            this.tickets_count = tickets_count;
        }

        public void setCards_count(float cards_count) {
            this.cards_count = cards_count;
        }

        public void setGamified_campaign_id(String gamified_campaign_id) {
            this.gamified_campaign_id = gamified_campaign_id;
        }

        public void setIs_anonymous(boolean is_anonymous) {
            this.is_anonymous = is_anonymous;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
        }

        public void setKey_managed_by(String key_managed_by) {
            this.key_managed_by = key_managed_by;
        }

        public void setSource(Source sourceObject) {
            this.SourceObject = sourceObject;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public void set__v(float __v) {
            this.__v = __v;
        }

        public void setWallet_address(String wallet_address) {
            this.wallet_address = wallet_address;
        }

        public void setCountry_id(String country_id) {
            this.country_id = country_id;
        }

        public void setSolana_address(Solana_address solana_addressObject) {
            this.Solana_addressObject = solana_addressObject;
        }

        public void setCrypto_nonce(String crypto_nonce) {
            this.crypto_nonce = crypto_nonce;
        }

        public void setCrypto_wallet(Crypto_wallet crypto_walletObject) {
            this.Crypto_walletObject = crypto_walletObject;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setApi_token(String api_token) {
            this.api_token = api_token;
        }

        public void setApi_token_expires_in(float api_token_expires_in) {
            this.api_token_expires_in = api_token_expires_in;
        }

        public void setDefault_payment_method(String default_payment_method) {
            this.default_payment_method = default_payment_method;
        }

        public void setTransaction_count(float transaction_count) {
            this.transaction_count = transaction_count;
        }

        public void setBids_count(float bids_count) {
            this.bids_count = bids_count;
        }

        public void setHas_winnings(boolean has_winnings) {
            this.has_winnings = has_winnings;
        }
    }
    public class Crypto_wallet {
        private String nonce;


        // Getter Methods

        public String getNonce() {
            return nonce;
        }

        // Setter Methods

        public void setNonce(String nonce) {
            this.nonce = nonce;
        }
    }
    public class Solana_address {
        private String address;
        private String privateKey;


        // Getter Methods

        public String getAddress() {
            return address;
        }

        public String getPrivateKey() {
            return privateKey;
        }

        // Setter Methods

        public void setAddress(String address) {
            this.address = address;
        }

        public void setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
        }
    }

    public class Source {
        private String host;
        private String url;
        private String agent;
        private String ip;


        // Getter Methods

        public String getHost() {
            return host;
        }

        public String getUrl() {
            return url;
        }

        public String getAgent() {
            return agent;
        }

        public String getIp() {
            return ip;
        }

        // Setter Methods

        public void setHost(String host) {
            this.host = host;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setAgent(String agent) {
            this.agent = agent;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }
    public class Following {
        ArrayList < Object > fund_raisers = new ArrayList < Object > ();
        ArrayList< Object > organizations = new ArrayList < Object > ();


        // Getter Methods



        // Setter Methods


    }

}
