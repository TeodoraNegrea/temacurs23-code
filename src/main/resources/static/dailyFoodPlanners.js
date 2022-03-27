$(document).ready(() => {
$('#add-button-modal').click(() => {
    const days = $('modal-days').val();

}
)}
)

$(document).ready(() => {
    $('#add-button-modal').click(() => {
        const products = $('#modal-products').val();
        const days = $('#modal-days').val();

        const newDailyFoodPlanner = {
            products: products,
            days: days
        };

        fetch('api/dailyFoodPlanners', {
            method: 'POST',
            body: JSON.stringify(newDailyFoodPlanner),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("There are errors " + response.status);
            }
        });
    });

    $('.delete-icon').click(function () {
        const dailyFoodPlannerDays = this.parentElement.days;

        fetch('api/dailyFoodPlanners/' + dailyFoodPlannerDays, {
            method: 'DELETE'
        }).then(response => location.reload());
    });
});