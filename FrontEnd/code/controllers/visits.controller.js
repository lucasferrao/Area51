
const server = 'https://paint4all.herokuapp.com/spaceSponsors';
window.onload = function () {
    //calls function to update spaceSponsor
    const dataTableSpaceSponsor =  document.getElementById("dataTableSpaceSponsor")
    const renderSpaceSponsors = async () => {
        let strHtml = `
    <thead>
    <tr>

    <th class='w-2'>#</th>
    <th>Nome Patrocinador</th>
    <th>Nº Patrocinador</th>
    <th>Nº Espaço</th>
    <th>Nome Espaço</th>
    <th>Estado</th>
    <tbody>
    </tr>
    </thead>
    `
        const response = await fetch(server)
        const SpaceSponsors = await response.json()
        let i = 1
        for (const spaceSponsor of spaceSponsors){
            /* var ts = new Date(user.birthdate);*/
            strHtml += `
        <tr>

        <td>${i}</td>
        <td>${spaceSponsor.price} </td>
        <td>${spaceSponsor.space_sponsor_date}</td>
        <td>${spaceSponsor.date_expiration}</td>
        <td>${spaceSponsor.is_exclusive}</td>
        <td>${spaceSponsor.id_space}</td>
        <td>${spaceSponsor.id_sponsor}</td>
        <td>${spaceSponsor.sponsor_ex}</td>

                            
        </tr>
            `
            i++
        }
        strHtml += "</tbody>"
        dataTableSpaceSponsor.innerHTML = strHtml
    }
    renderSpaceSponsors()
}