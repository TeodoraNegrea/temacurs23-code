$(document).ready(() => {
    let dailyFoodPlannerToEdit;

    $('#add-button-modal').click(() => {
        //extragem valorile introduse in modal
        const products = $('#modal-products').val();

        //construim noul obiect transaction din modal
        const newDailyFoodPlanner = {
            products: products
        };

        if (dailyFoodPlannerToEdit == null) {
            addDailyFoodPlanner(newDailyFoodPlanner);
        } else {
            editDailyFoodPlanner(dailyFoodPlannerToEdit, newDailyFoodPlanner);
        }
    });

    function editDailyFoodPlanner(days, newDailyFoodPlanner) {
        fetch('api/dailyFoodPlanners/' + days, {
            method: 'PUT',
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
    }
});

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
});


    $('.edit-icon').click(function () {
            //extragem id-ul din html, de pe parintele iconitei de edit
            dailyFoodPlannerToEdit = this.parentElement.id;
            //extragem elementul din html care reprezinta randul unui tabel
            const row = this.parentElement.parentElement;
            //extragem textul din prima casuta din row
            const products = row.children[0].innerText;


            //setam valoarea in html pt modal
            $('#modal-products').val(description);
     });


    $('.delete-icon').click(function () {
        const id = this.parentElement.id;
        const day = 'TUESDAY';

        fetch('api/dailyFoodPlanners/' + day + id , {
            method: 'DELETE'
        }).then(response => location.reload());

});
    $('#add-dailyFoodPlanner-button').click(function () {
        dailyFoodPlannerToEdit = null;
        clearModal();
    });