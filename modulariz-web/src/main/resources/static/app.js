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

    userController = {
        el: "#userController",
        data: {
            users: [
                {name: 'John Snow'},
                {name: 'Mark so'}
            ]
        }
    };

    exports.app = new Vue(exchangeController);
    exports.app = new Vue(userController);
})(window);

