ymaps.ready(init);

function init() {
    let map = new ymaps.Map('widget-map', {
        center: [59.94892727754434,30.318982137709053], // SPB_CENTER
        zoom: 12,
        controls: []
    }, {});
}