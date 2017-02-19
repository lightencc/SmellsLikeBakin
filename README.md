# SmellsLikeBakin
this is a demo app to show how to use fragments

- The main fragment will attach to main activity.
- In the main fragment, there is a list show all the recipes it has.
- When user click the item of the list, the main activity implements a listener to replace the current attached fragment to the detail - fragment.
- The detail fragment contains two fragments by using a viewpager, it receives the parameters from last fragment through a bundle to display the information about the selected item.
- User can switch the display from clicking the tablayout button, it can integrate with the viewpager.
- When user click the back button, it will return to the main fragment that in the back stack before.
- When user rotate the screen it will cause the activity life cycle restart, in the oncreate funciton, we need to find the previous fragment instead of creating a new one.
- We also need to consider the screen size to show different display in different devices, such like to check if there is a tablet.
- When we make the app to adapt to the different devices, we need to refactor the code, so we don't have to sacrifice code reuse.
