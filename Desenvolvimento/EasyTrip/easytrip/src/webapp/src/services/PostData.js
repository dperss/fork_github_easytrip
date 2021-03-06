export function PostData(type, userData) {
    let BaseURL = "http://localhost:8080/";

    return new Promise ((resolve, reject) => {


        fetch(BaseURL + type, {
            method: 'POST',
            body: JSON.stringify(userData)
            })
            .then((response) => response.json())
            .then((responseJson) =>{

                resolve(responseJson);
            })
            .catch((error) => {
                reject(error);
            });



    });
}