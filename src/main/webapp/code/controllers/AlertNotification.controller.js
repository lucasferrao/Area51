const serverAlertNotification = '/Area51/alerts/novosMovimentos';

function checkForAlerts() {
    fetch(serverAlertNotification)
        .then(response => response.json())
        .then(alertJson => {
            if(alertJson === false) {
                checkForAlerts();
                return;
            }

            // Recebido novo alerta! Processar o alerta.
            window.location.href = "/Area51/code/sensorMovementAlert.html?id_alert=" + alertJson.id_alert
                + "&id_device=" + alertJson.id_device
                + "&alert_hour=" + alertJson.alert_hour
                + "&alert_date=" + alertJson.alert_date;
        })
        .catch(() => {
            checkForAlerts();
        });
}

$(document).ready(checkForAlerts);
