(function () {
    self.addEventListener('install', event => {
        console.log('service worker installing');
        self.skipWaiting();
    });

    self.addEventListener('activate', event => {
        console.log('service worker activating...');
    });

    self.addEventListener('fetch', function (event) {
        event.respondWith(
            caches.open('mysite').then(async function (cache) {
                console.log(cache);
                return cache.match(event.request).then(function (response) {
                    return response || fetch(event.request).then(function (response) {
                        cache.put(event.request, response.clone());
                        return response;
                    });
                });
            })
        );
    });
})();
