function priceSorter(a, b) {
    var aa = a.replace('€', '')
    var bb = b.replace('€', '')
    return aa - bb
}

function nbDaysSorter(a, b) {
    var aa = a.replace(' jours', '')
    var bb = b.replace(' jours', '')
    return aa - bb
}

function dateSorter(a, b) {
    var aa = a.split('-').reverse();
    var bb = b.split('-').reverse();
    return Date.parse(aa.join('-')) - Date.parse(bb.join('-'));
}