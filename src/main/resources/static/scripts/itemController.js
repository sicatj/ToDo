//Doing a Product web app, in product page to 
//display the name, description, imageUrl, style, price, ..., ...,.....,....


const createToDoItem = (index, title, description, date) =>
`
                <tr>
                <td>${index}</td>
                <td>${title}</td>
                <td>${description}</td>
                <td>${date}</td>
                </tr>
`;


class ItemController
{
    constructor()
    {
        this._items = [];       //create an array to store the details of product items
    }


    renderItemPage()
        {
            var toDoItemsList = [];

            for (var i=0; i<this._items.length; i++)
            {
                const item = this._items[i];            //assign the individual item to the variable

                const itemListing = createToDoItem(item.id, item.title, item.description, item.date);

                toDoItemsList.push(itemListing);
            }

            //Join all the elements/items in my productHTMLList array into one string, and seperate by a break
            const listingInsertion = toDoItemsList.join('\n');
            document.getElementById("tasklist").getElementsByTagName('tbody')[0].innerHTML = listingInsertion;

        }


displayItem()
    {
        var toDoItemController = this;
        toDoItemController._items = [];

        //fetch data from database using the REST API endpoint from Spring Boot
        fetch('http://127.0.0.1:8080/item/all')
            .then((resp) => resp.json())
            .then(function(data) {
                console.log("2. receive data")
                console.log(data);
                data.forEach(function (item, index) {

                    const itemObj = {
                        id: item.id,
                        title: item.title,
                        description: item.description,
                        date: item.date
                   };
                    toDoItemController._items.push(itemObj);
              });

              toDoItemController.renderItemPage();

            })
            .catch(function(error) {
                console.log(error);
            });
    }


addItem(title, description, date)
    {
        var productController = this;
        const formData = new FormData();
        formData.append('title', title);
        formData.append('description', description);
        formData.append('date', date);

       fetch('http://localhost:8080/item/add', {
             method: 'POST',
             body: formData
             })
             .then(function(response) {
                 console.log(response.status);
                 if (response.ok) {
                     alert("One more task on your TO DOs!")
                 }
             })
             .catch((error) => {
                 console.error('Error:', error);
                 alert("Couldn't add the task for some reason")
             });
    }


}   //End of ProductsController class
