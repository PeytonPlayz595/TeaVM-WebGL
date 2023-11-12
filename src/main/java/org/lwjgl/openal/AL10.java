package org.lwjgl.openal;

public interface AL10 {
    /** Bad value */
	int AL_INVALID = -1;

	/** Disable value */
	int AL_NONE = 0;

	/** Boolean False */
	int AL_FALSE = 0;

	/** Boolean True */
	int AL_TRUE = 1;

	/**
	 * Indicate the type of SOURCE.
	 * Sources can be spatialized
	 */
	int AL_SOURCE_TYPE = 0x1027;

	/** Indicate source has absolute coordinates */
	int AL_SOURCE_ABSOLUTE = 0x201;

	/** Indicate Source has listener relative coordinates */
	int AL_SOURCE_RELATIVE = 0x202;

	/**
	 * Directional source, inner cone angle, in degrees
	 * Range:		[0-360]
	 * Default:	360
	 */
	int AL_CONE_INNER_ANGLE = 0x1001;

	/**
	 * Directional source, outer cone angle, in degrees.
	 * Range:		[0-360]
	 * Default:	360
	 */
	int AL_CONE_OUTER_ANGLE = 0x1002;

	/**
	 * Specify the pitch to be applied, either at source,
	 * or on mixer results, at listener.
	 * Range:	[0.5-2.0]
	 * Default:	1.0
	 */
	int AL_PITCH = 0x1003;

	/**
	 * Specify the current location in three dimensional space.
	 * OpenAL, like OpenGL, uses a right handed coordinate system,
	 * where in a frontal default view X (thumb) points right,
	 * Y points up (index finger), and Z points towards the
	 * viewer/camera (middle finger).
	 * To switch from a left handed coordinate system, flip the
	 * sign on the Z coordinate.
	 * Listener position is always in the world coordinate system.
	 */
	int AL_POSITION = 0x1004;

	/** Specify the current direction as forward vector. */
	int AL_DIRECTION = 0x1005;

	/** Specify the current velocity in three dimensional space. */
	int AL_VELOCITY = 0x1006;

	/**
	 * Indicate whether source has to loop infinite.
	 * Type: ALboolean
	 * Range:		[TRUE, FALSE]
	 * Default:	FALSE
	 */
	int AL_LOOPING = 0x1007;

	/**
	 * Indicate the buffer to provide sound samples.
	 * Type: ALuint.
	 * Range: any valid Buffer id.
	 */
	int AL_BUFFER = 0x1009;

	/**
	 * Indicate the gain (volume amplification) applied.
	 * Type:		 ALfloat.
	 * Range:		]0.0-	]
	 * A value of 1.0 means un-attenuated/unchanged.
	 * Each division by 2 equals an attenuation of -6dB.
	 * Each multiplicaton with 2 equals an amplification of +6dB.
	 * A value of 0.0 is meaningless with respect to a logarithmic
	 * scale; it is interpreted as zero volume - the channel
	 * is effectively disabled.
	 */
	int AL_GAIN = 0x100A;

	/**
	 * Indicate minimum source attenuation.
	 * Type:		 ALfloat
	 * Range:	[0.0 - 1.0]
	 */
	int AL_MIN_GAIN = 0x100D;

	/**
	 * Indicate maximum source attenuation.
	 * Type:	 ALfloat
	 * Range:	[0.0 - 1.0]
	 */
	int AL_MAX_GAIN = 0x100E;

	/**
	 * Specify the current orientation.
	 * Type:	 ALfv6 (at/up)
	 * Range:	N/A
	 */
	int AL_ORIENTATION = 0x100F;

	/* byte offset into source (in canon format).	-1 if source
	 * is not playing.	Don't set this, get this.
	 *
	 * Type:		 ALfloat
	 * Range:		[0.0 - ]
	 * Default:	1.0
	 */
	int AL_REFERENCE_DISTANCE = 0x1020;

	/**
	 * Indicate the rolloff factor for the source.
	 * Type: ALfloat
	 * Range:		[0.0 - ]
	 * Default:	1.0
	 */
	int AL_ROLLOFF_FACTOR = 0x1021;

	/**
	 * Indicate the gain (volume amplification) applied.
	 * Type:		 ALfloat.
	 * Range:		]0.0-	]
	 * A value of 1.0 means un-attenuated/unchanged.
	 * Each division by 2 equals an attenuation of -6dB.
	 * Each multiplicaton with 2 equals an amplification of +6dB.
	 * A value of 0.0 is meaningless with respect to a logarithmic
	 * scale; it is interpreted as zero volume - the channel
	 * is effectively disabled.
	 */
	int AL_CONE_OUTER_GAIN = 0x1022;

	/**
	 * Specify the maximum distance.
	 * Type:	 ALfloat
	 * Range:	[0.0 - ]
	 */
	int AL_MAX_DISTANCE = 0x1023;

	/**
	 * Specify the channel mask. (Creative)
	 * Type:	 ALuint
	 * Range:	[0 - 255]
	 */
	int AL_CHANNEL_MASK = 0x3000;

	/** Source state information */
	int AL_SOURCE_STATE = 0x1010;

	/** Source state information */
	int AL_INITIAL = 0x1011;

	/** Source state information */
	int AL_PLAYING = 0x1012;

	/** Source state information */
	int AL_PAUSED = 0x1013;

	/** Source state information */
	int AL_STOPPED = 0x1014;

	/** Buffer Queue params */
	int AL_BUFFERS_QUEUED = 0x1015;

	/** Buffer Queue params */
	int AL_BUFFERS_PROCESSED = 0x1016;

	/** Sound buffers: format specifier. */
	int AL_FORMAT_MONO8 = 0x1100;

	/** Sound buffers: format specifier. */
	int AL_FORMAT_MONO16 = 0x1101;

	/** Sound buffers: format specifier. */
	int AL_FORMAT_STEREO8 = 0x1102;

	/** Sound buffers: format specifier. */
	int AL_FORMAT_STEREO16 = 0x1103;

	/** Ogg Vorbis format specifier. */
	int AL_FORMAT_VORBIS_EXT = 0x10003;

	/**
	 * Sound buffers: frequency, in units of Hertz [Hz].
	 * This is the number of samples per second. Half of the
	 * sample frequency marks the maximum significant
	 * frequency component.
	 */
	int AL_FREQUENCY = 0x2001;

	/**
	 * Sound buffers: The number of bits per sample for the
	 * data contained in the buffer.
	 */
	int AL_BITS = 0x2002;

	/**
	 * Sound buffers: The number of channels for the data
	 * contained in the buffer.
	 */
	int AL_CHANNELS = 0x2003;

	/**
	 * Sound buffers: Size in bytes of the buffer data.
	 */
	int AL_SIZE = 0x2004;

	/**
	 * @deprecated This token is a relict of the early OpenAL days and is
	 * no longer supported. Neither the OpenAL spec nor OpenAL Soft define
	 * it.
	 */
	@Deprecated
	int AL_DATA = 0x2005;

	/**
	 * Buffer state.
	 *
	 * Not supported for public use (yet).
	 */
	int AL_UNUSED = 0x2010;

	/**
	 * Buffer state.
	 *
	 * Not supported for public use (yet).
	 */
	int AL_PENDING = 0x2011;

	/**
	 * Buffer state.
	 *
	 * Not supported for public use (yet).
	 */
	int AL_PROCESSED = 0x2012;

	/** Errors: No Error. */
	int AL_NO_ERROR = AL_FALSE;

	/** Illegal name passed as an argument to an AL call. */
	int AL_INVALID_NAME = 0xA001;

	/** Illegal enum passed as an argument to an AL call. */
	int AL_INVALID_ENUM = 0xA002;

	/**
	 * Illegal value passed as an argument to an AL call.
	 * Applies to parameter values, but not to enumerations.
	 */
	int AL_INVALID_VALUE = 0xA003;

	/**
	 * A function was called at inappropriate time,
	 *	or in an inappropriate way, causing an illegal state.
	 * This can be an incompatible ALenum, object ID,
	 *	and/or function.
	 */
	int AL_INVALID_OPERATION = 0xA004;

	/**
	 * A function could not be completed,
	 * because there is not enough memory available.
	 */
	int AL_OUT_OF_MEMORY = 0xA005;

	/** Context strings: Vendor */
	int AL_VENDOR = 0xB001;

	/** Context strings: Version */
	int AL_VERSION = 0xB002;

	/** Context strings: Renderer */
	int AL_RENDERER = 0xB003;

	/** Context strings: Extensions */
	int AL_EXTENSIONS = 0xB004;

	/** Doppler scale.	Default 1.0 */
	int AL_DOPPLER_FACTOR = 0xC000;

	/** Doppler velocity.	Default 1.0 */
	int AL_DOPPLER_VELOCITY = 0xC001;

	/** Distance model.	Default INVERSE_DISTANCE_CLAMPED */
	int AL_DISTANCE_MODEL = 0xD000;

	/** Distance model */
	int AL_INVERSE_DISTANCE = 0xD001;

	/** Distance model */
	int AL_INVERSE_DISTANCE_CLAMPED = 0xD002;
}