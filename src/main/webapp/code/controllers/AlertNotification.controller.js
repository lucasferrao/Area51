const serverAlertNotification = '/Area51/alerts/novosMovimentos';

window.onload = async function () {
    while(true) {
        let response;
        do {
            response = await fetch(serverAlertNotification);
        } while (!response.ok);

        let alertJson = await response.json();

        // Foi recebido um novo alerta! Processar o alerta.
        window.location.href = "/Area51/code/sensorMovementAlert.html?id=" + alertJson.id + "&id_device=" + alertJson.id_device;
    }
};
