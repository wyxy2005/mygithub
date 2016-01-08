.class public Lcom/qihoo/util/StubApplication;
.super Landroid/app/Application;
.source "StubApplication.java"


# static fields
.field private static context:Landroid/content/Context;

.field public static newApp:Landroid/app/Application;

.field public static runApp:Landroid/app/Application;

.field private static soName:Ljava/lang/String;

.field public static strEntryApplication:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    const/4 v1, 0x0

    .line 20
    sput-object v1, Lcom/qihoo/util/StubApplication;->runApp:Landroid/app/Application;

    .line 21
    const-string v0, "com.qihoo360.crypt.entryRunApplication"

    sput-object v0, Lcom/qihoo/util/StubApplication;->strEntryApplication:Ljava/lang/String;

    .line 22
    sput-object v1, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;

    .line 23
    const-string v0, "libjiagu"

    sput-object v0, Lcom/qihoo/util/StubApplication;->soName:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method

.method public static ChangeTopApplication()V
    .registers 2

    .prologue
    .line 61
    sget-object v0, Lcom/qihoo/util/StubApplication;->runApp:Landroid/app/Application;

    invoke-virtual {v0}, Landroid/app/Application;->getBaseContext()Landroid/content/Context;

    move-result-object v0

    .line 63
    :try_start_6
    sget-object v1, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;

    invoke-static {v1, v0}, Lcom/qihoo/util/StubApplication;->interface7(Landroid/app/Application;Landroid/content/Context;)Z
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_b} :catch_c

    .line 67
    :goto_b
    return-void

    .line 64
    :catch_c
    move-exception v0

    .line 65
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_b
.end method

.method public static copy(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .registers 12

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 155
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 157
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, p2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 165
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_27

    .line 166
    invoke-virtual {v3}, Ljava/io/File;->mkdir()Z

    .line 168
    :cond_27
    :try_start_27
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 170
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_60

    .line 171
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v4

    invoke-virtual {v4, p1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v4

    .line 172
    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 173
    new-instance v3, Ljava/io/BufferedInputStream;

    invoke-direct {v3, v4}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 174
    new-instance v6, Ljava/io/BufferedInputStream;

    invoke-direct {v6, v5}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 175
    invoke-static {v3, v6}, Lcom/qihoo/util/StubApplication;->isSameFile(Ljava/io/BufferedInputStream;Ljava/io/BufferedInputStream;)Z

    move-result v7

    if-eqz v7, :cond_60

    .line 177
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 178
    invoke-virtual {v5}, Ljava/io/InputStream;->close()V

    .line 179
    invoke-virtual {v3}, Ljava/io/BufferedInputStream;->close()V

    .line 180
    invoke-virtual {v6}, Ljava/io/BufferedInputStream;->close()V

    .line 200
    :goto_5f
    return v0

    .line 185
    :cond_60
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v3

    invoke-virtual {v3, p1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v3

    .line 186
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    .line 188
    const/16 v2, 0x1c00

    new-array v2, v2, [B

    .line 190
    :goto_75
    invoke-virtual {v3, v2}, Ljava/io/InputStream;->read([B)I

    move-result v5

    if-lez v5, :cond_86

    .line 191
    const/4 v6, 0x0

    invoke-virtual {v4, v2, v6, v5}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_7f
    .catch Ljava/lang/Exception; {:try_start_27 .. :try_end_7f} :catch_80

    goto :goto_75

    .line 196
    :catch_80
    move-exception v0

    .line 197
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    move v0, v1

    .line 198
    goto :goto_5f

    .line 193
    :cond_86
    :try_start_86
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->close()V

    .line 194
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_8c
    .catch Ljava/lang/Exception; {:try_start_86 .. :try_end_8c} :catch_80

    goto :goto_5f
.end method

.method public static getAppContext()Landroid/content/Context;
    .registers 1

    .prologue
    .line 29
    sget-object v0, Lcom/qihoo/util/StubApplication;->context:Landroid/content/Context;

    return-object v0
.end method

.method public static getNewAppInstance(Landroid/content/Context;)Landroid/app/Application;
    .registers 3

    .prologue
    .line 40
    :try_start_0
    sget-object v0, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;

    if-nez v0, :cond_1a

    .line 41
    invoke-virtual {p0}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 42
    if-eqz v0, :cond_1a

    .line 43
    sget-object v1, Lcom/qihoo/util/StubApplication;->strEntryApplication:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 44
    if-eqz v0, :cond_1a

    .line 45
    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Application;

    sput-object v0, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;
    :try_end_1a
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_1a} :catch_1d

    .line 51
    :cond_1a
    :goto_1a
    sget-object v0, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;

    return-object v0

    .line 48
    :catch_1d
    move-exception v0

    .line 49
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1a
.end method

.method public static native interface5(Landroid/app/Application;)V
.end method

.method public static native interface6(Ljava/lang/String;)Ljava/lang/String;
.end method

.method public static native interface7(Landroid/app/Application;Landroid/content/Context;)Z
.end method

.method public static native interface8(Landroid/app/Application;Landroid/content/Context;)Z
.end method

.method public static isSameFile(Ljava/io/BufferedInputStream;Ljava/io/BufferedInputStream;)Z
    .registers 9

    .prologue
    const/4 v0, 0x0

    .line 205
    :try_start_1
    invoke-virtual {p0}, Ljava/io/BufferedInputStream;->available()I

    move-result v2

    .line 206
    invoke-virtual {p1}, Ljava/io/BufferedInputStream;->available()I

    move-result v1

    .line 208
    if-ne v2, v1, :cond_1e

    .line 209
    new-array v3, v2, [B

    .line 210
    new-array v4, v1, [B

    .line 212
    invoke-virtual {p0, v3}, Ljava/io/BufferedInputStream;->read([B)I

    .line 213
    invoke-virtual {p1, v4}, Ljava/io/BufferedInputStream;->read([B)I

    move v1, v0

    .line 215
    :goto_16
    if-ge v1, v2, :cond_22

    .line 216
    aget-byte v5, v3, v1

    aget-byte v6, v4, v1
    :try_end_1c
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1c} :catch_24
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1c} :catch_29

    if-eq v5, v6, :cond_1f

    .line 229
    :cond_1e
    :goto_1e
    return v0

    .line 215
    :cond_1f
    add-int/lit8 v1, v1, 0x1

    goto :goto_16

    .line 220
    :cond_22
    const/4 v0, 0x1

    goto :goto_1e

    .line 224
    :catch_24
    move-exception v1

    .line 225
    invoke-virtual {v1}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_1e

    .line 226
    :catch_29
    move-exception v1

    .line 227
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1e
.end method

.method public static isX86Arch()Ljava/lang/Boolean;
    .registers 7

    .prologue
    const/4 v1, 0x0

    const/4 v6, 0x1

    .line 82
    :try_start_2
    sget-object v2, Landroid/os/Build;->SUPPORTED_32_BIT_ABIS:[Ljava/lang/String;

    array-length v3, v2

    move v0, v1

    :goto_6
    if-ge v0, v3, :cond_63

    aget-object v4, v2, v0

    .line 83
    const-string v5, "x86"

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_18

    .line 84
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_16
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_16} :catch_1b

    move-result-object v0

    .line 108
    :goto_17
    return-object v0

    .line 82
    :cond_18
    add-int/lit8 v0, v0, 0x1

    goto :goto_6

    .line 87
    :catch_1b
    move-exception v0

    .line 89
    sget-object v0, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    const-string v2, "x86"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_30

    sget-object v0, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    const-string v2, "x86"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_35

    .line 90
    :cond_30
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_17

    .line 93
    :cond_35
    :try_start_35
    new-instance v2, Ljava/io/RandomAccessFile;

    const-string v0, "/system/build.prop"

    const-string v3, "r"

    invoke-direct {v2, v0, v3}, Ljava/io/RandomAccessFile;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 94
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->readLine()Ljava/lang/String;

    move-result-object v0

    .line 95
    :goto_42
    if-eqz v0, :cond_63

    .line 96
    const-string v3, "ro.product.cpu.abi"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_5a

    const-string v3, "x86"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_5a

    .line 97
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_17

    .line 98
    :cond_5a
    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->readLine()Ljava/lang/String;
    :try_end_5d
    .catch Ljava/io/FileNotFoundException; {:try_start_35 .. :try_end_5d} :catch_5f
    .catch Ljava/io/IOException; {:try_start_35 .. :try_end_5d} :catch_68

    move-result-object v0

    goto :goto_42

    .line 100
    :catch_5f
    move-exception v0

    .line 102
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V

    .line 108
    :cond_63
    :goto_63
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_17

    .line 103
    :catch_68
    move-exception v0

    .line 105
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_63
.end method

.method public static native n01130(Ljava/lang/Object;)V
.end method

.method public static native n0113331(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)I
.end method


# virtual methods
.method protected attachBaseContext(Landroid/content/Context;)V
    .registers 8

    .prologue
    const/4 v3, 0x0

    const/4 v5, 0x1

    .line 113
    invoke-super {p0, p1}, Landroid/app/Application;->attachBaseContext(Landroid/content/Context;)V

    .line 114
    sput-object p1, Lcom/qihoo/util/StubApplication;->context:Landroid/content/Context;

    .line 116
    sget-object v0, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;

    if-nez v0, :cond_bb

    .line 117
    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    .line 118
    invoke-static {}, Lcom/qihoo/util/StubApplication;->isX86Arch()Ljava/lang/Boolean;

    move-result-object v2

    .line 119
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 121
    sget-object v3, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    const-string v4, "arm64"

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2f

    sget-object v3, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    const-string v4, "arm64"

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_33

    .line 122
    :cond_2f
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 124
    :cond_33
    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_f2

    .line 125
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/qihoo/util/StubApplication;->soName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_x86.so"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/qihoo/util/StubApplication;->soName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".so"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {p1, v2, v1, v3}, Lcom/qihoo/util/StubApplication;->copy(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    .line 129
    :goto_66
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_121

    .line 130
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/qihoo/util/StubApplication;->soName:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "_64.so"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/qihoo/util/StubApplication;->soName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_64.so"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {p1, v0, v1, v2}, Lcom/qihoo/util/StubApplication;->copy(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    .line 131
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/qihoo/util/StubApplication;->soName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_64.so"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/System;->load(Ljava/lang/String;)V

    .line 137
    :cond_bb
    :goto_bb
    sget-object v0, Lcom/qihoo/util/StubApplication;->runApp:Landroid/app/Application;

    if-nez v0, :cond_c1

    .line 138
    sput-object p0, Lcom/qihoo/util/StubApplication;->runApp:Landroid/app/Application;

    .line 139
    :cond_c1
    invoke-static {p1}, Lcom/qihoo/util/StubApplication;->getNewAppInstance(Landroid/content/Context;)Landroid/app/Application;

    move-result-object v0

    sput-object v0, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;

    .line 140
    sget-object v0, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;

    if-eqz v0, :cond_ec

    .line 142
    :try_start_cb
    const-class v0, Landroid/app/Application;

    const-string v1, "attach"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    const-class v4, Landroid/content/Context;

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 143
    if-eqz v0, :cond_ec

    .line 144
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    .line 145
    sget-object v1, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_ec
    .catch Ljava/lang/Exception; {:try_start_cb .. :try_end_ec} :catch_145

    .line 151
    :cond_ec
    :goto_ec
    sget-object v0, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;

    invoke-static {v0, p1}, Lcom/qihoo/util/StubApplication;->interface8(Landroid/app/Application;Landroid/content/Context;)Z

    .line 153
    return-void

    .line 127
    :cond_f2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/qihoo/util/StubApplication;->soName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".so"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/qihoo/util/StubApplication;->soName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".so"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {p1, v2, v1, v3}, Lcom/qihoo/util/StubApplication;->copy(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    goto/16 :goto_66

    .line 133
    :cond_121
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/qihoo/util/StubApplication;->soName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".so"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/System;->load(Ljava/lang/String;)V

    goto/16 :goto_bb

    .line 147
    :catch_145
    move-exception v0

    .line 148
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_ec
.end method

.method public native n1110()V
.end method

.method public native n1111112(III)J
.end method

.method public native n11121(J)I
.end method

.method public native n111211(JI)I
.end method

.method public native n1112111(JII)I
.end method

.method public native n1112111131(JIIIILjava/lang/Object;)I
.end method

.method public native n11121311(JILjava/lang/Object;Z)I
.end method

.method public native n1112131111(JILjava/lang/Object;IIZ)I
.end method

.method public native n1112312(JLjava/lang/Object;C)J
.end method

.method public native n111231331111(JLjava/lang/Object;BLjava/lang/Object;Ljava/lang/Object;ZII)I
.end method

.method public native n11123313133312(JLjava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;I)J
.end method

.method public native n11123313133313313111112(JLjava/lang/Object;Ljava/lang/Object;CLjava/lang/Object;CLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;BLjava/lang/Object;Ljava/lang/Object;ZLjava/lang/Object;IIIII)J
.end method

.method public native n1113()Ljava/lang/Object;
.end method

.method public native n1113111(Ljava/lang/Object;II)I
.end method

.method public native n11131111(Ljava/lang/Object;III)I
.end method

.method public native n111331(Ljava/lang/Object;Ljava/lang/Object;)I
.end method

.method public onCreate()V
    .registers 2

    .prologue
    .line 71
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 72
    invoke-static {}, Lcom/qihoo/util/StubApplication;->ChangeTopApplication()V

    .line 73
    sget-object v0, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;

    if-eqz v0, :cond_14

    .line 74
    sget-object v0, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;

    invoke-static {v0}, Lcom/qihoo/util/StubApplication;->interface5(Landroid/app/Application;)V

    .line 75
    sget-object v0, Lcom/qihoo/util/StubApplication;->newApp:Landroid/app/Application;

    invoke-virtual {v0}, Landroid/app/Application;->onCreate()V

    .line 79
    :cond_14
    return-void
.end method
