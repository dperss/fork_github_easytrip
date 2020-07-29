### `npm start`

Runs the app in the development mode.<br />
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.<br />
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.<br />
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.<br />
It correctly bundles React in production mode and optimizes the build for the best performance.

# GET
    http://localhost:8081/rest/users?pageNumber=0&pageSize=5&sortBy=email&sortDir=asc
    
# GET By ID
	http://localhost:8081/rest/users/10

# GET By Email
		http://localhost:8081/rest/users/email/test@test.co
	
# POST
	http://localhost:8081/rest/users

# PUT
	http://localhost:8081/rest/users

# DELETE
	http://localhost:8081/rest/persons/10
	
	
	
http://localhost:8081/swagger-ui/index.html

/v2/api-docs