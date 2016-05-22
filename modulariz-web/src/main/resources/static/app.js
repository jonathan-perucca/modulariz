(function(exports) {

    exchangeController = {
        el: '#exchangeController',
        data: {
            exchanges: [
                {state: 'PENDING', owner: 'John Snow', receiver: 'Mark so'},
                {state: 'PENDING', owner: 'Mark so', receiver: 'John Snow'}
            ]
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

