

const itemsControl = new ItemController();

newItemForm.addEventListener('submit', (event) => {

    event.preventDefault();

    const newItemTitle = document.getElementById("title");
    const newItemDescription = document.getElementById("description");
    const newItemDate = document.getElementById("date");

    const title = newItemTitle.value;
    const description = newItemDescription.value;
    const date = newItemDate.value;
    console.log(date);

    newItemTitle.value = '';
    newItemDescription.value = '';
    newItemDate.value = '';


    itemsControl.addItem(title, description, date);

});


