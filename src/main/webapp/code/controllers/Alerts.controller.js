
const server = '/Area51/alerts';

$("#dataTableAlerts").dataTable({
    "ajax": {
        "url": server,
        "type": "GET",
        "dataSrc": ""
    }
});
