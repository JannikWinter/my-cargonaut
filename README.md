![Cargonaut Logo](./mockups/img/logo.png)
# MyCargonaut
MyCargonaut is a community driven web app solution to private cargo delivering. In short, MyCargonaut aims to be a
platform where users can offer to drive other user's cargo from point A to point B. Any monetary transactions will be
handled between users; MyCargonaut will not take a cent in cuts.

MyCargonaut was created in tandem with the THM computer science lecture KMS as the big programming project of the 
semester.

## Technologies

MyCargonaut uses a platera of different technologies to get the job done:

The whole backend is build on an union of `ES6 JavaScript` and `openjdk15 Java`, enabled via `Javalin 3.13`.

The front end is basic `HTML5` on a custom `Bootstrap 5.0.0` stylesheet as well as a few manual 
`CSS3` additions. MyCargonaut uses server-sided rendering via a relatively new template engine for Java: 
[JTE](https://github.com/casid/jte)

Regarding code maintenance we are using `JUnit5` as well as `npm 7.5.2` for general testing, as well as tools like 
`TravisCI` and `HoundCI` for continuous deployment & delivery on GitHub.

## Prerequisites

### Host
For best results, the host machine requires a modern UNIX operating system. You will need `gradle 6.7.1` or compatible 
version, as well as `openjdk15` or higher.

### Client
The client will only require a connection to the host system and any modern web browser.

## Install

MyCargonaut does not need to be installed on any client, since it's a host-rendering based web application. 
We do however need to set up the host machine:

After meeting all prerequisites, you will need to build the program with `gradle`. For that, move to the `my-cargonaut`
folder via the terminal and execute the command `gradle build`.
![Gradle build](./mockups/readme/gradleBuild.png)

When the project has been build, you are able to simply run MyCargonaut on your host machine via the command `gradle run`. 
![Gradle run](./mockups/readme/gradle_run.png)

You can then open MyCargonaut from any client machine. On default the address for that would be `http://localhost:7777/`,
but this can be changed in `./src/main/java/my_cargonaut/App.java` in line `86`, simply by changing the value of 
`app.start(7777);`.

Note that you will still need to be able to set that address in the first place.

## Feature Showcase

MyCargonaut is still WIP; it is more a technical demo created by two college students than a real business product.
It still offers some features you might want to see before downloading/using it.

The user interface is entirely in German and we have alot of dummy date still present, like the name of the company 
owner, company adress etc.

### Landing page
![Landing page](mockups/readme/landing.PNG)

### Create offer
![Create offer](./mockups/readme/create.PNG)
As of now we only support offers, not requests.

### Search offer
![Search offer](./mockups/readme/Search.PNG)
You enter the query at the landing page, which will redirect you to this site. It'll show you every entry that matches your
query.

### Profile w/ dummy data
![Profile](./mockups/readme/profile.PNG)
Neither linking your Paypal nor uploading a new profile picture works right now. Those buttons are mere clickers.

### Deals
![Deals](./mockups/readme/deals.PNG)

### Carpool
![Carpool](./mockups/readme/cars.PNG)

We managed to add persistency to MyCargonaut. Any accounts created, cars included to the car pools and especially 
entries added, will remain after shutting down the host server. 

## Proof of concept

We have managed to port a version of MyCargonaut to 
[Heroku](https://kms-mycargonaut.herokuapp.com/), but do the `JTE` limitations, we were forced to abandon some features,
like persistency.

The fork can be found [here](https://github.com/LucasF-42/my-cargonaut-v2). This fork is only used as a proof of concept
and may not work as well as this version.

## Contributing
Pull requests are welcome, but we don't plan on continuing the work on this project. The idea & icons of MyCargonaut 
came from the lecturers of the THM class "Konzepte moderner Softwareentwicklung" and are not our intellectual property.

## License
[MIT](https://choosealicense.com/licenses/mit/)