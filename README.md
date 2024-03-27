# MVA APP Automation
#### This is the automation repo for MVA UK App Automation

## Tools Needed
- IntelliJ (Download Community Edition): https://www.jetbrains.com/idea/download/
  If admin rights popup appears during installation just cancel and it will continue normally
- Java 17:  https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
  - Download suitable Java according to your Machine
  - Extract the zip file into any location then refer to the jdk from intellij
- Appium (Download Java Client): https://appium.io/downloads.html
- Android Studio (Get it from ITShop)
- Git: https://git-scm.com/downloads
  - If admin rights popup appears during installation just cancel and it will continue normally

####  Notes:
- Refer to the jdk downloaded from IntelliJ (File structure)
- add vm into run configuration vm = --add-opens java.base/java.lang=ALL-UNNAMED
- Open Appium configuration and make sure it referes to the correct JDK and Android SDK home paths

## Work Process
- Git fetch
- Update the Release branch related to the sprint Release/RXX.X
- Checkout to the Release branch related to the sprint Release/RXX.X
- Create a new branch from the Release branch related to the sprint Release/RXX.X
- Do the work in your branch
- Commit and push only the files related to the feature (Don't commit config or core files changes)
- Create a pull request to the Release branch related to the sprint Release/RXX.X
  - Only create a pull request when both Android and iOS run successfully
  - You should add the Android and iOS run reports links in the pull request description and you should link the user story workitem to the pull request
  - Assign the pull request to Ahmed AbdelHamid - Ali ElSaeed and the Sinai member supporting your squad
  - Post the pull request link to mva-automation-pull-requests and tag Ahmed AbdelHamid - Ali ElSaeed and the Sinai member supporting your squad
  - Check the pull request comments then resolve it and commit your changes (This is a continus process accrding to the comments)
  - Wait for the reviewer to approve and merge the pull request then close your story