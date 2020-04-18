const camerasServer = '/Area51/cameras';

function showCameraInfo(id) {
    fetch(camerasServer + "?id_camera=" + id)
        .then(result => result.json())
        .then(camara => {
            $("#modalCamera #camera").html("Dispositivo: " + camara.id);
            $("#modalCamera #place").html("Localização: " + camara.device_location);
            $("#modalCamera #info").html("Reparações: " + camara.repair_history);
        })
        .catch(err => {
            console.log(err);
        });
}

$(document).ready(() => showCameraInfo(1));
