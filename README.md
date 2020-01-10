# Embedded-linux-with-beaglebone-black
Learning beaglebone with embedded linux

## Introduction
BeagleBone Black(BBB) Board Introduction :

It is actually redundant to explain about Beaglebone hardware, when you can get all the info regarding this board from its official site here 

The community describes this board as follows

#### “Beaglebone Black is a low-cost, community-supported development platform for developers and hobbyists. Boot Linux in under 10 seconds and get started on development in less than 5 minutes with just a single USB cable.”

So, you should pay attention to these points 

### 1. It’s an open source h/w, s/w platform. 

That means, if you are planning to design your own single board computer (a SBC), then you can reuse the Beaglebone black’s design, schematics, software, etc. So, the beaglebone hardware enables you to quickly come up with your own customized board. Most of the companies ,what they do is , they take the BBB hardware design, like part numbers, schematics , BOM etc and they add customer specific add-ons or features then release the product to the market. 

When the hardware team is working on the new hardware, the software team will not sit idle, they test their software, drivers, and applications on reference ( such as Beaglebone ) board, which greatly reduces the time to market effort.  

### 2. A low cost Single Board Computer (SBC)

The BBB hardware is powerful yet low cost SBC currently available. 

So, what’s a SBC?

When a single piece of circuit board, comprises most of the personal Computer hardware/software components, then it is called as a SBC. Of course you cannot have terra bytes of hard disk mounted on a circuit board, but it has significant amount of on board memory, it has wireless/wired connectivity, it has USB interfaces, it can run operating systems, you can connect to monitor or projector. Yes! You can compare this with the motherboard of your PC.

 Hence it is called as single board computer. Another most famous SBC is Raspberry PI but it is partially an “open hardware” because the SOC manufacturer hides the details. 

### 3. BBB uses TI’s AM355x SOC, which can run at 1GHZ clock speed

Heart of the BBB SBC is a SOC by Texas instruments. 
So , What is a SOC ? 

//figure
 SOC stands for System on Chip. As the name indicates, a single chip contains most of the essential computing /communication/storage engine of the computing world, like Flash memory, Graphics processing engine, the image 

processing engine, the USB communication engine, RS232, SPI, I2C engine and much more. The heart of the SOC is a processor.

For example AM355x SOC is powered by ARM cortex A8 processor.

Explore more about AM355x SOC from here:

http://www.ti.com/product/AM3359 

### 4. Managed by Beagleboard.org 

You can get full source schematics, hardware layout files, a full Bill of materials (BOM), and technical reference manuals from the beagleboard.org

You can also get software updates, prebuilt images, and sample codes by following the beagleboard.org.

Now let’s pay attention to some of the important hardware parts of the BBB Rev C board. 
//figure
#### 1) The AM355x SOC by TI

As I already mentioned, this SOC is from TI and can run up to the speed of 1GHZ and the SOC is powered by ARM cortex A8 processor.

The exact name of the SOC is : AM3358BZCZ100  on REV ‘C’ BBB Board

The Technical Reference manual of this SOC can be found here , 

http://www.ti.com/lit/ug/spruh73p/spruh73p.pdf

(Need not to go through this document now, as we make a progress we will explore details from this document whenever required)

#### 2) Embedded MMC (eMMC)

The board has 4GB of eMMC(embedded Multi Media Controller) memory chip, This is an on-board  memory chip that holds up to 4GB of data in BBB Rev C.

Accessing data from this memory is much faster than accessing through external micro sd card , and remember that the board boots from this memory by default. But you can always change, from where the boot should boot, more on this is covered later. 

#### 3) SDRAM Memory: 512MB DDR3 

This is external Dynamic RAM memory, the board comes with SDRAM Memory: 512MB DDR3. This is on the board and connected to SOC. I will cover more on memory interfaces later in this course. They claim this memory as, faster and low power RAM memory. During booting the boot images will get loaded to this RAM from other memories and will execute from here, more on this later. 

#### 4) Serial(UART) pin outs. 

The BBB hardware doesn’t come with on board UART to usb convertor chip. But , what they have given is serial port pin outs. They want you to get an external uart to usb convertor hardware and connect to these pins in order to get the debug messages from the board on to your Host PC serial monitoring software.

More on this covered later in the course.  

#### 5) The boot button (S2)

As I said, the board boots from on-board eMMC memory by default, so instead of eMMC booting, if you want to boot from the external SD card, then you have to use this button (S2). By pressing and holding this button, if you apply the power or press the power button, then board will boot from the external SD Card.

More on this later, don’t worry for a time being. 

#### 6) The 4 User LEDs. 

There are 4 on board LEDs to play around; we will see how we can access these 4 LEDs through ‘c’ programming as well using Linux SYSFS Techniques later in this course. I will also explain about their connection to the SOC GPIO ports. 

#### 7) Power button (S3)

Unlike older beagle boards, the beagleboard.org added this button on the BBB, which offers you the control to turn on and turn off the power to the board. Great isn’t it? That means you need not to plug out the power source from this board if you want to turn off the board, just press this button and the board will enter in to power down mode. and pressing again will turn on the power. 

#### 8) Powering the BBB board. 

There are 2 options to power the board. 

1> Through the Mini USB port

The mini USB cable comes with the BBB, and using that cable you can power the board by connecting it to your PC. At max it can only get the current of 500mA . Note that there are 2 mini USB ports on the board. You should use the one which is adjacent to the Ethernet connector which says P4.

But powering through USB has couple of disadvantages.

 1) You won’t be able to run the board at full speed

 2) You won’t be able to drive the LCD

 3) You will not be able to drive the some Beaglebone capes connected over expansion headers.

But don’t worry most of the time the current from the USB cable connected to PC is sufficient and you may not need to buy power adapter unless you connect lots of power hungry peripherals to the BBB. 

2> DC Barrel Plug 5.5mm/2.1mm (Recommended 5V @ 2A) 

You can also power the board by connecting a DC power adapter to the board; it should limit the current to max 2A. This power adapter won’t come with the board and you have to purchase it separately only if required

•          The operating voltage must be 5V.

•          The operating current is recommended to be 1.2A to 2A.

Check the next article about other external components which may be required with the BBB hardware. 

#### 9) BBB Back Side View 

I have covered only important hardware details about the board.

I highly recommend you to read the BBB user manual before working on it. The official user manual will always be best place to understand the hardware better.

 http://elinux.org/Beagleboard:BeagleBoneBlack 
