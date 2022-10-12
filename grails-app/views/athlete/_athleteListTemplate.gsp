<g:each in="${athletes}" var="athlete">
    <tr>
        <td>${athlete.id}</td>
        <td>${athlete.firstName}</td>
        <td>${athlete.lastName}</td>
        <td>${athlete.phoneNumber}</td>
        <td>${athlete.email}</td>
        <td>
            <div class="row">
                <div class="col">
                    <g:link controller="athlete" class="text-decoration-none"
                            params="${[id: athlete.id]}" action="edit">
                        Update
                    </g:link>
                    <asset:javascript src="confirmation.js" />
                    <g:link controller="athlete" class="text-decoration-none" onclick="return getConfirmationAthleteDelete()"
                            params="${[athleteId: athlete.id]}" action="deleteAthlete">
                        Delete
                    </g:link>
        </td>
    </tr>
</g:each>
