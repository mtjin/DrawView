# DrawView
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![](https://jitpack.io/v/mtjin/DrawView.svg)](https://jitpack.io/#mtjin/DrawView)
<br>
Library that draw on View and have some useful functions
It is useful for drawing and signature

## Prerequisites
Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.mtjin:DrawView:v1.0'
}
```

## Usage

There is also sample code in this repository. (https://github.com/mtjin/DrawView/tree/master/app)

To change pen color
```kotlin
drawView.setPenColor(Color.parseColor("#D81B60"))
```

To change pen stroke width
```kotlin
drawView.setStrokeWidth(20f)
```

To undo draw 
```kotlin
drawView.undo()
```

To redo draw 
```kotlin
drawView.redo()
```

To clear all draw
```kotlin
drawView.clear()
```

To get Bitmap from only draw line of DrawView
```kotlin
val bitmap = drawView.getBitmapDrawLine()
imageView.setImageBitmap(bitmap)
```

To get Bitmap from DrawView
```kotlin
val bitmap = drawView.getBitmap()
imageView.setImageBitmap(bitmap)
```

Download File to gallery and get the Uri, it needs WRITE_EXTERNAL_STORAGE permission (drawVie file)
```kotlin
 drawView.saveFileDrawViewGetUri()
 //Only Download
 saveFileDrawView() 
```

Download File to gallery and get the Uri, it needs WRITE_EXTERNAL_STORAGE permission (draw line file , background : whitecolor)
```kotlin
 drawView.saveFileDrawLineGetUri()
 //Only Download
saveFileDrawLine()
```

To get Draw Path List
```kotlin
 drawView.getPathList()
```

To get Draw Point(x,y) List
```kotlin
 drawView.getPointList()
```

save image file second method

```kotlin
val bitmap = drawImageView.getBitmap()
        var outStream: FileOutputStream? = null
        val sdCard: File = Environment.getExternalStorageDirectory()
        val dir = File(sdCard.absolutePath + "/DrawApp")
        dir.mkdirs()
        val fileName =
            String.format("%d.jpg", System.currentTimeMillis())
        val outFile = File(dir, fileName)
        outStream = FileOutputStream(outFile)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream)
        outStream.flush()
        outStream.close()
```

It can also set by xml
```xml
<com.mtjin.library.DrawView
       android:layout_width="wrap_content"
       app:pen_color="#4455B7"
       app:pen_stroke="30"
       android:layout_height="wrap_content"/>
```

## Sample
I also used this library for my app


Project: https://github.com/mtjin/VisionApp/tree/master/Real_VisionApp/VisionApp


Sample Video : https://www.youtube.com/watch?v=30-KBgfjirs&feature=youtu.be


## Images
<div>
<img src="https://user-images.githubusercontent.com/37071007/78999801-56c7f300-7b86-11ea-99e6-1a361edd2290.png" height="400" width="200" >
<img src="https://user-images.githubusercontent.com/37071007/78999818-61828800-7b86-11ea-8884-e91584522f35.png" height="400" width="200" >
<img src="https://user-images.githubusercontent.com/37071007/78999833-66473c00-7b86-11ea-843f-16b2ee59d063.png" height="400" width="200" >
<img src="https://user-images.githubusercontent.com/37071007/78999839-6a735980-7b86-11ea-9563-835ace663d6e.png"  height="400" width="200" >
<img src="https://user-images.githubusercontent.com/37071007/78999843-6cd5b380-7b86-11ea-9848-13482607d284.png"  height="400" width="200" >
<img src="https://user-images.githubusercontent.com/37071007/78999850-6fd0a400-7b86-11ea-95c8-8f7c8bd842df.png"  height="400" width="200" >
<img src="https://user-images.githubusercontent.com/37071007/104920298-ec789480-59da-11eb-9deb-400ca335ae8f.png"  height="400" width="200" >
<img src="https://user-images.githubusercontent.com/37071007/104920320-f4383900-59da-11eb-9789-f9403abe35df.png"  height="400" width="200" >
</div>

## Other My Libraries
[BorderEditText](https://github.com/mtjin/BorderEditText)


## License
```
MIT License

Copyright (c) 2021 JackJackE

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
