
//option 1
//get the slider and wher eto display size
var slider1 = document.getElementById("option1Slider");
var output1 = document.getElementById("option1Value");


//Changes font size based on slider
slider1.oninput = async function() {
  //display font size
  output1.innerHTML = this.value;
  //creates the css code to be injected
  const cssCode = '* { font-size: '+ slider1.value +'px !important; }';

  try {
    const tab_Id = await getTabID();
    // STries to remove old css code (doesnt work currently)
    chrome.scripting.removeCSS({
      target: { tabId: tab_Id },
      css: cssCode,
    })
    //injects css code
    chrome.scripting.insertCSS({
      target: { tabId: tab_Id },
      css: cssCode,
    })//error trapping (still probably good but mostly juist a remenant from when it didnt work)
    .then(() => console.log("CSS injected"))
    .catch(error => console.error("Error injecting CSS:", error));
  } catch (error) {
    console.error("Error:", error);
  }
}


//option 2
//get buttons
var hyperButton = document.getElementById("hyperLegibleButton");
var sansButton = document.getElementById("comicSansButton");

//changes font on button click
//Atkinson Hyperlegible
hyperButton.onclick = async function() {
  //creates the css code to be injected
  const cssCode = "@import url('https://fonts.googleapis.com/css2?family=Atkinson+Hyperlegible&display=swap');"
  +"* { font-family: 'Atkinson Hyperlegible', sans-serif  !important; }";

  try {
    const tab_Id = await getTabID();
    // STries to remove old css code (doesnt work currently)
    chrome.scripting.removeCSS({
      target: { tabId: tab_Id },
      css: cssCode,
    })
    //injects css code
    chrome.scripting.insertCSS({
      target: { tabId: tab_Id },
      css: cssCode,
    })//error trapping (still probably good but mostly juist a remenant from when it didnt work)
    .then(() => console.log("CSS injected"))
    .catch(error => console.error("Error injecting CSS:", error));
  } catch (error) {
    console.error("Error:", error);
  }
}
//comic sans
sansButton.onclick = async function() {
  //creates the css code to be injected
  const cssCode = "* { font-family: 'Comic Sans MS', 'Comic Sans', cursive;  !important; }";

  try {
    const tab_Id = await getTabID();
    // STries to remove old css code (doesnt work currently)
    chrome.scripting.removeCSS({
      target: { tabId: tab_Id },
      css: cssCode,
    })
    //injects css code
    chrome.scripting.insertCSS({
      target: { tabId: tab_Id },
      css: cssCode,
    })//error trapping (still probably good but mostly juist a remenant from when it didnt work)
    .then(() => console.log("CSS injected"))
    .catch(error => console.error("Error injecting CSS:", error));
  } catch (error) {
    console.error("Error:", error);
  }
}

// Function to get active tab ID
function getTabID() {
  return new Promise((resolve, reject) => {
    chrome.tabs.query({ active: true, currentWindow: true }, function(tabs) {
      if (tabs && tabs.length > 0) {
        const activeTabId = tabs[0].id;
        console.log("Active tab ID:", activeTabId);
        resolve(activeTabId);
      } else {
        console.error("No active tabs found");
        reject(new Error("No active tabs found"));
      }
    });
  });
}


