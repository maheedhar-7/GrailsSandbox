<g:each in="${activities}" var="activity">
    <tr>
        <td>${activity.id}</td>
    <td>${activity.activity}</td>
    <td>
        <g:formatDate format="dd/MM/yyyy HH:mm" date="${activity.startDate}"/>
    </td>
    <td>
        <g:formatDate format="dd/MM/yyyy HH:mm" date="${activity.endDate}"/>
    </td>
    <td>${activity.pace}</td>
    <td>
        <g:link controller="activity" class="text-decoration-none"
                params="${[activityId: activity.id]}" action="update">
            Update
        </g:link>
        <asset:javascript src="confirmation.js" />
            <g:link controller="activity" onclick="return getConfirmation()" class="text-decoration-none"
                    params="${[activityId: activity.id]}" action="delete">
                Delete
            </g:link>
    </td>
</tr>
</g:each>