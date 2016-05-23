(function(exports) {

    exchangeController = {
        el: '#exchangeController',
        data: {
            exchanges: []
        },
        ready: function() {
            this.fetchExchanges();
        },
        methods: {
            fetchExchanges: function() {
                this.$http
                    .get("/exchanges")
                    .then(function(response) {
                        this.$set('exchanges', response.data);
                    }, function(_) {
                        this.$set('exchanges', [{owner: "Aucun échange ..."}]);
                    })
            },
            pushState: function(exchange) {
                var exchanges = this.$get('exchanges');
                this.$http.post("/exchanges", exchange, function(response) {
                    exchanges.$remove(exchange);
                    exchanges.push(response);
                });
            }
        }
    };

    accountController = {
        el: "#accountController",
        data: {
            accounts: []
        },
        ready: function() {
            this.fetchAccounts();
        },
        methods: {
            fetchAccounts: function() {
                this.$http
                    .get('/accounts')
                    .then(function (response) {
                        this.$set('accounts', response.data)
                    }, function(_) {
                        this.$set('accounts', [{name:'Aucun compte ...'}]);
                    });
            }
        }
    };

    exports.app = new Vue(exchangeController);
    exports.app = new Vue(accountController);
})(window);

