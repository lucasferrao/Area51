
const server = '/Area51/alerts';
$(document).ready(function() {
$("#dataTableAlerts").dataTable({
    "ajax": {
        "url": server,
        "type": "GET",
        "dataSrc": ""
    }
})});
