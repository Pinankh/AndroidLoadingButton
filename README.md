# Progress Button Android

![enter image description here](https://i.stack.imgur.com/8SHR1.gif)

Android Button that morphs into a loading progress bar.

  - Fully customizable in the XML
  - Really simple to use.
  - Makes your app looks cooler =D


## Contents

 - [Installation](#installation)
 - [How to use / Sample](#how-to-use)
	 - [Animate and revert animation](#animate-and-revert-animation)
	 -  [Show done animation](#show-done-animation)
	 - [Revert the loading animation with different text or image](#revert-the-loading-animation-with-different-text-or-image)
 - [Configure XML](#configure-xml)
 - [Avoid Memory Leaks](#avoid-memory-leaks)
 - [Be Creative](#be-creative)
 - [Bugs and feedback](#bugs-and-feedback)
 - [Credits](#credits)

## Installation 

```
implementation("pinankh:loading-button:3.0.0")
```

## How to use

### Animate and revert animation

Add the button in your layout file and customize it the way you like it.

```xml
<pinankh.loadingbutton.customViews.CircularProgressButton
	android:id="@+id/btn_id"
	android:layout_width="match_parent"
	android:layout_height="wrap_content"
	android:background="@drawable/circular_border_shape"
	app:spinning_bar_width="4dp" <!-- Optional -->
	app:spinning_bar_color="#FFF" <!-- Optional -->
	app:spinning_bar_padding="6dp" /> <!-- Optional -->
```

Then, instanciate the button

```java
CircularProgressButton btn = (CircularProgressButton) findViewById(R.id.btn_id)
btn.startAnimation();

//[do some async task. When it finishes]
//You can choose the color and the image after the loading is finished
btn.doneLoadingAnimation(fillColor, bitmap);

//[or just revert de animation]
btn.revertAnimation();
```

You can also add a callback to trigger an action after the startAnimation has finished resizing the button :

```kotlin
btn.startAnimation {
	<start async task>
}
```

### Switch to determinant progress
You can switch between indeterminant and determinant progress:

```java
circularProgressButton.setProgress(10)
...
circularProgressButton.setProgress(50)
...
circularProgressButton.setProgress(100)
```

### - Show 'done' animation

When the loading animation is running, call:

```java
//Choose the color and the image that will be show
circularProgressButton.doneLoadingAnimation(fillColor, bitmap);
```

### - Revert the loading animation with different text or image

```kotlin
progressButton.revertAnimation {
	progressButton.text = "Some new text"
}
```

or

```kotlin
progressImageButton.revertAnimation {
	progressImageButton.setImageResource(R.drawable.image)
}
```

### - Button State

This button is a state machine and it changes its state during the animation process. The states are:

#### Before Draw
This state is the initial one, the button is in this state before the View is draw on the screen. This is the state when the button is accesed in the `onCreate()` of an Activity. 

#### Idle
After the button is drawn in the screen, it gets in the `Idle` state. It is basically waiting for an animation. Call `startAnimation()` to start animations with this button.

#### WAITING_PROGRESS
If the `startAnimation()` is called before the `Idle` state, the button goes to this state. The button waits for the button to be drawn in the screen before start the morph animation.

#### MORPHING
The button stays in this state during the morphing animation.

#### PROGRESS
After the morph animation, the button start the progress animation. From this state the `done` and `revert` animations can happen.

#### MORPHING_REVERT
The button stays in this state during the morphing animation reversal. 

#### WAITING_DONE
If the `doneLoadingAnimation(fillColor: Int, bitmap: Bitmap)` is called when the button is still morphing, it enter in this state. The button waits for the morph animation to complete and then start the done animation.

#### DONE
The button enters this state when the `doneLoadingAnimation` finishes.

#### WAITING\_TO\_STOP
The button enters this state when the `stopAnimation()` is called before the morph state is completed. The button waits for the morph animation to complete and the stops further animations. 

#### STOPPED
The button enters this state after `stopAnimation()` when the button is not morphing. 

## Configure XML

 - `app:spinning_bar_width` : Changes the width of the spinning bar inside the button
 - `app:spinning_bar_color`: Changes the color of the spinning bar inside the button
 - `app:spinning_bar_padding`: Changes the padding of the spinning bar in relation of the button bounds.
 - `app:initialCornerAngle`: The initial corner angle of the animation. Insert 0 if you have a square button.
 - `app:finalCornerAngle`: The final corner angle of the animation.

### And that's it! Enjoy!
****

<!-- CONTACT -->
## Contact

Pinankh Patel - pinankhpatel@hotmail.com

Linkedin: https://www.linkedin.com/in/pinankh-patel-19400350/
