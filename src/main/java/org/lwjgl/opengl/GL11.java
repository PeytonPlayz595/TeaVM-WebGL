package org.lwjgl.opengl;

import java.util.*;
import java.nio.*;

import static org.lwjgl.opengl.WebGL.*;
import org.lwjgl.util.vector.*;

public class GL11 {

	//OpenGL Enums

	// Field descriptor #544 I
	public static final int GL_ACCUM = 256;

	// Field descriptor #544 I
	public static final int GL_LOAD = 257;

	// Field descriptor #544 I
	public static final int GL_RETURN = 258;

	// Field descriptor #544 I
	public static final int GL_MULT = 259;

	// Field descriptor #544 I
	public static final int GL_ADD = 260;

	// Field descriptor #544 I
	public static final int GL_NEVER = 512;

	// Field descriptor #544 I
	public static final int GL_LESS = 513;

	// Field descriptor #544 I
	public static final int GL_EQUAL = 514;

	// Field descriptor #544 I
	public static final int GL_LEQUAL = 515;

	// Field descriptor #544 I
	public static final int GL_GREATER = 516;

	// Field descriptor #544 I
	public static final int GL_NOTEQUAL = 517;

	// Field descriptor #544 I
	public static final int GL_GEQUAL = 518;

	// Field descriptor #544 I
	public static final int GL_ALWAYS = 519;

	// Field descriptor #544 I
	public static final int GL_CURRENT_BIT = 1;

	// Field descriptor #544 I
	public static final int GL_POINT_BIT = 2;

	// Field descriptor #544 I
	public static final int GL_LINE_BIT = 4;

	// Field descriptor #544 I
	public static final int GL_POLYGON_BIT = 8;

	// Field descriptor #544 I
	public static final int GL_POLYGON_STIPPLE_BIT = 16;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MODE_BIT = 32;

	// Field descriptor #544 I
	public static final int GL_LIGHTING_BIT = 64;

	// Field descriptor #544 I
	public static final int GL_FOG_BIT = 128;

	// Field descriptor #544 I
	public static final int GL_DEPTH_BUFFER_BIT = 256;

	// Field descriptor #544 I
	public static final int GL_ACCUM_BUFFER_BIT = 512;

	// Field descriptor #544 I
	public static final int GL_STENCIL_BUFFER_BIT = 1024;

	// Field descriptor #544 I
	public static final int GL_VIEWPORT_BIT = 2048;

	// Field descriptor #544 I
	public static final int GL_TRANSFORM_BIT = 4096;

	// Field descriptor #544 I
	public static final int GL_ENABLE_BIT = 8192;

	// Field descriptor #544 I
	public static final int GL_COLOR_BUFFER_BIT = 16384;

	// Field descriptor #544 I
	public static final int GL_HINT_BIT = 32768;

	// Field descriptor #544 I
	public static final int GL_EVAL_BIT = 65536;

	// Field descriptor #544 I
	public static final int GL_LIST_BIT = 131072;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_BIT = 262144;

	// Field descriptor #544 I
	public static final int GL_SCISSOR_BIT = 524288;

	// Field descriptor #544 I
	public static final int GL_ALL_ATTRIB_BITS = 1048575;

	// Field descriptor #544 I
	public static final int GL_POINTS = 0;

	// Field descriptor #544 I
	public static final int GL_LINES = 1;

	// Field descriptor #544 I
	public static final int GL_LINE_LOOP = 2;

	// Field descriptor #544 I
	public static final int GL_LINE_STRIP = 3;

	// Field descriptor #544 I
	public static final int GL_TRIANGLES = 4;

	// Field descriptor #544 I
	public static final int GL_TRIANGLE_STRIP = 5;

	// Field descriptor #544 I
	public static final int GL_TRIANGLE_FAN = 6;

	// Field descriptor #544 I
	public static final int GL_QUADS = 7;

	// Field descriptor #544 I
	public static final int GL_QUAD_STRIP = 8;

	// Field descriptor #544 I
	public static final int GL_POLYGON = 9;

	// Field descriptor #544 I
	public static final int GL_ZERO = 0;

	// Field descriptor #544 I
	public static final int GL_ONE = 1;

	// Field descriptor #544 I
	public static final int GL_SRC_COLOR = 768;

	// Field descriptor #544 I
	public static final int GL_ONE_MINUS_SRC_COLOR = 769;

	// Field descriptor #544 I
	public static final int GL_SRC_ALPHA = 770;

	// Field descriptor #544 I
	public static final int GL_ONE_MINUS_SRC_ALPHA = 771;

	// Field descriptor #544 I
	public static final int GL_DST_ALPHA = 772;

	// Field descriptor #544 I
	public static final int GL_ONE_MINUS_DST_ALPHA = 773;

	// Field descriptor #544 I
	public static final int GL_DST_COLOR = 774;

	// Field descriptor #544 I
	public static final int GL_ONE_MINUS_DST_COLOR = 775;

	// Field descriptor #544 I
	public static final int GL_SRC_ALPHA_SATURATE = 776;

	// Field descriptor #544 I
	public static final int GL_CONSTANT_COLOR = 32769;

	// Field descriptor #544 I
	public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;

	// Field descriptor #544 I
	public static final int GL_CONSTANT_ALPHA = 32771;

	// Field descriptor #544 I
	public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;

	// Field descriptor #544 I
	public static final int GL_TRUE = 1;

	// Field descriptor #544 I
	public static final int GL_FALSE = 0;

	// Field descriptor #544 I
	public static final int GL_CLIP_PLANE0 = 12288;

	// Field descriptor #544 I
	public static final int GL_CLIP_PLANE1 = 12289;

	// Field descriptor #544 I
	public static final int GL_CLIP_PLANE2 = 12290;

	// Field descriptor #544 I
	public static final int GL_CLIP_PLANE3 = 12291;

	// Field descriptor #544 I
	public static final int GL_CLIP_PLANE4 = 12292;

	// Field descriptor #544 I
	public static final int GL_CLIP_PLANE5 = 12293;

	// Field descriptor #544 I
	public static final int GL_BYTE = 5120;

	// Field descriptor #544 I
	public static final int GL_UNSIGNED_BYTE = 5121;

	// Field descriptor #544 I
	public static final int GL_SHORT = 5122;

	// Field descriptor #544 I
	public static final int GL_UNSIGNED_SHORT = 5123;

	// Field descriptor #544 I
	public static final int GL_INT = 5124;

	// Field descriptor #544 I
	public static final int GL_UNSIGNED_INT = 5125;

	// Field descriptor #544 I
	public static final int GL_FLOAT = 5126;

	// Field descriptor #544 I
	public static final int GL_2_BYTES = 5127;

	// Field descriptor #544 I
	public static final int GL_3_BYTES = 5128;

	// Field descriptor #544 I
	public static final int GL_4_BYTES = 5129;

	// Field descriptor #544 I
	public static final int GL_DOUBLE = 5130;

	// Field descriptor #544 I
	public static final int GL_NONE = 0;

	// Field descriptor #544 I
	public static final int GL_FRONT_LEFT = 1024;

	// Field descriptor #544 I
	public static final int GL_FRONT_RIGHT = 1025;

	// Field descriptor #544 I
	public static final int GL_BACK_LEFT = 1026;

	// Field descriptor #544 I
	public static final int GL_BACK_RIGHT = 1027;

	// Field descriptor #544 I
	public static final int GL_FRONT = 1028;

	// Field descriptor #544 I
	public static final int GL_BACK = 1029;

	// Field descriptor #544 I
	public static final int GL_LEFT = 1030;

	// Field descriptor #544 I
	public static final int GL_RIGHT = 1031;

	// Field descriptor #544 I
	public static final int GL_FRONT_AND_BACK = 1032;

	// Field descriptor #544 I
	public static final int GL_AUX0 = 1033;

	// Field descriptor #544 I
	public static final int GL_AUX1 = 1034;

	// Field descriptor #544 I
	public static final int GL_AUX2 = 1035;

	// Field descriptor #544 I
	public static final int GL_AUX3 = 1036;

	// Field descriptor #544 I
	public static final int GL_NO_ERROR = 0;

	// Field descriptor #544 I
	public static final int GL_INVALID_ENUM = 1280;

	// Field descriptor #544 I
	public static final int GL_INVALID_VALUE = 1281;

	// Field descriptor #544 I
	public static final int GL_INVALID_OPERATION = 1282;

	// Field descriptor #544 I
	public static final int GL_STACK_OVERFLOW = 1283;

	// Field descriptor #544 I
	public static final int GL_STACK_UNDERFLOW = 1284;

	// Field descriptor #544 I
	public static final int GL_OUT_OF_MEMORY = 1285;

	// Field descriptor #544 I
	public static final int GL_2D = 1536;

	// Field descriptor #544 I
	public static final int GL_3D = 1537;

	// Field descriptor #544 I
	public static final int GL_3D_COLOR = 1538;

	// Field descriptor #544 I
	public static final int GL_3D_COLOR_TEXTURE = 1539;

	// Field descriptor #544 I
	public static final int GL_4D_COLOR_TEXTURE = 1540;

	// Field descriptor #544 I
	public static final int GL_PASS_THROUGH_TOKEN = 1792;

	// Field descriptor #544 I
	public static final int GL_POINT_TOKEN = 1793;

	// Field descriptor #544 I
	public static final int GL_LINE_TOKEN = 1794;

	// Field descriptor #544 I
	public static final int GL_POLYGON_TOKEN = 1795;

	// Field descriptor #544 I
	public static final int GL_BITMAP_TOKEN = 1796;

	// Field descriptor #544 I
	public static final int GL_DRAW_PIXEL_TOKEN = 1797;

	// Field descriptor #544 I
	public static final int GL_COPY_PIXEL_TOKEN = 1798;

	// Field descriptor #544 I
	public static final int GL_LINE_RESET_TOKEN = 1799;

	// Field descriptor #544 I
	public static final int GL_EXP = 2048;

	// Field descriptor #544 I
	public static final int GL_EXP2 = 2049;

	// Field descriptor #544 I
	public static final int GL_CW = 2304;

	// Field descriptor #544 I
	public static final int GL_CCW = 2305;

	// Field descriptor #544 I
	public static final int GL_COEFF = 2560;

	// Field descriptor #544 I
	public static final int GL_ORDER = 2561;

	// Field descriptor #544 I
	public static final int GL_DOMAIN = 2562;

	// Field descriptor #544 I
	public static final int GL_CURRENT_COLOR = 2816;

	// Field descriptor #544 I
	public static final int GL_CURRENT_INDEX = 2817;

	// Field descriptor #544 I
	public static final int GL_CURRENT_NORMAL = 2818;

	// Field descriptor #544 I
	public static final int GL_CURRENT_TEXTURE_COORDS = 2819;

	// Field descriptor #544 I
	public static final int GL_CURRENT_RASTER_COLOR = 2820;

	// Field descriptor #544 I
	public static final int GL_CURRENT_RASTER_INDEX = 2821;

	// Field descriptor #544 I
	public static final int GL_CURRENT_RASTER_TEXTURE_COORDS = 2822;

	// Field descriptor #544 I
	public static final int GL_CURRENT_RASTER_POSITION = 2823;

	// Field descriptor #544 I
	public static final int GL_CURRENT_RASTER_POSITION_VALID = 2824;

	// Field descriptor #544 I
	public static final int GL_CURRENT_RASTER_DISTANCE = 2825;

	// Field descriptor #544 I
	public static final int GL_POINT_SMOOTH = 2832;

	// Field descriptor #544 I
	public static final int GL_POINT_SIZE = 2833;

	// Field descriptor #544 I
	public static final int GL_POINT_SIZE_RANGE = 2834;

	// Field descriptor #544 I
	public static final int GL_POINT_SIZE_GRANULARITY = 2835;

	// Field descriptor #544 I
	public static final int GL_LINE_SMOOTH = 2848;

	// Field descriptor #544 I
	public static final int GL_LINE_WIDTH = 2849;

	// Field descriptor #544 I
	public static final int GL_LINE_WIDTH_RANGE = 2850;

	// Field descriptor #544 I
	public static final int GL_LINE_WIDTH_GRANULARITY = 2851;

	// Field descriptor #544 I
	public static final int GL_LINE_STIPPLE = 2852;

	// Field descriptor #544 I
	public static final int GL_LINE_STIPPLE_PATTERN = 2853;

	// Field descriptor #544 I
	public static final int GL_LINE_STIPPLE_REPEAT = 2854;

	// Field descriptor #544 I
	public static final int GL_LIST_MODE = 2864;

	// Field descriptor #544 I
	public static final int GL_MAX_LIST_NESTING = 2865;

	// Field descriptor #544 I
	public static final int GL_LIST_BASE = 2866;

	// Field descriptor #544 I
	public static final int GL_LIST_INDEX = 2867;

	// Field descriptor #544 I
	public static final int GL_POLYGON_MODE = 2880;

	// Field descriptor #544 I
	public static final int GL_POLYGON_SMOOTH = 2881;

	// Field descriptor #544 I
	public static final int GL_POLYGON_STIPPLE = 2882;

	// Field descriptor #544 I
	public static final int GL_EDGE_FLAG = 2883;

	// Field descriptor #544 I
	public static final int GL_CULL_FACE = 2884;

	// Field descriptor #544 I
	public static final int GL_CULL_FACE_MODE = 2885;

	// Field descriptor #544 I
	public static final int GL_FRONT_FACE = 2886;

	// Field descriptor #544 I
	public static final int GL_LIGHTING = 2896;

	// Field descriptor #544 I
	public static final int GL_LIGHT_MODEL_LOCAL_VIEWER = 2897;

	// Field descriptor #544 I
	public static final int GL_LIGHT_MODEL_TWO_SIDE = 2898;

	// Field descriptor #544 I
	public static final int GL_LIGHT_MODEL_AMBIENT = 2899;

	// Field descriptor #544 I
	public static final int GL_SHADE_MODEL = 2900;

	// Field descriptor #544 I
	public static final int GL_COLOR_MATERIAL_FACE = 2901;

	// Field descriptor #544 I
	public static final int GL_COLOR_MATERIAL_PARAMETER = 2902;

	// Field descriptor #544 I
	public static final int GL_COLOR_MATERIAL = 2903;

	// Field descriptor #544 I
	public static final int GL_FOG = 2912;

	// Field descriptor #544 I
	public static final int GL_FOG_INDEX = 2913;

	// Field descriptor #544 I
	public static final int GL_FOG_DENSITY = 2914;

	// Field descriptor #544 I
	public static final int GL_FOG_START = 2915;

	// Field descriptor #544 I
	public static final int GL_FOG_END = 2916;

	// Field descriptor #544 I
	public static final int GL_FOG_MODE = 2917;

	// Field descriptor #544 I
	public static final int GL_FOG_COLOR = 2918;

	// Field descriptor #544 I
	public static final int GL_DEPTH_RANGE = 2928;

	// Field descriptor #544 I
	public static final int GL_DEPTH_TEST = 2929;

	// Field descriptor #544 I
	public static final int GL_DEPTH_WRITEMASK = 2930;

	// Field descriptor #544 I
	public static final int GL_DEPTH_CLEAR_VALUE = 2931;

	// Field descriptor #544 I
	public static final int GL_DEPTH_FUNC = 2932;

	// Field descriptor #544 I
	public static final int GL_ACCUM_CLEAR_VALUE = 2944;

	// Field descriptor #544 I
	public static final int GL_STENCIL_TEST = 2960;

	// Field descriptor #544 I
	public static final int GL_STENCIL_CLEAR_VALUE = 2961;

	// Field descriptor #544 I
	public static final int GL_STENCIL_FUNC = 2962;

	// Field descriptor #544 I
	public static final int GL_STENCIL_VALUE_MASK = 2963;

	// Field descriptor #544 I
	public static final int GL_STENCIL_FAIL = 2964;

	// Field descriptor #544 I
	public static final int GL_STENCIL_PASS_DEPTH_FAIL = 2965;

	// Field descriptor #544 I
	public static final int GL_STENCIL_PASS_DEPTH_PASS = 2966;

	// Field descriptor #544 I
	public static final int GL_STENCIL_REF = 2967;

	// Field descriptor #544 I
	public static final int GL_STENCIL_WRITEMASK = 2968;

	// Field descriptor #544 I
	public static final int GL_MATRIX_MODE = 2976;

	// Field descriptor #544 I
	public static final int GL_NORMALIZE = 2977;

	// Field descriptor #544 I
	public static final int GL_VIEWPORT = 2978;

	// Field descriptor #544 I
	public static final int GL_MODELVIEW_STACK_DEPTH = 2979;

	// Field descriptor #544 I
	public static final int GL_PROJECTION_STACK_DEPTH = 2980;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_STACK_DEPTH = 2981;

	// Field descriptor #544 I
	public static final int GL_MODELVIEW_MATRIX = 2982;

	// Field descriptor #544 I
	public static final int GL_PROJECTION_MATRIX = 2983;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_MATRIX = 2984;

	// Field descriptor #544 I
	public static final int GL_ATTRIB_STACK_DEPTH = 2992;

	// Field descriptor #544 I
	public static final int GL_CLIENT_ATTRIB_STACK_DEPTH = 2993;

	// Field descriptor #544 I
	public static final int GL_ALPHA_TEST = 3008;

	// Field descriptor #544 I
	public static final int GL_ALPHA_TEST_FUNC = 3009;

	// Field descriptor #544 I
	public static final int GL_ALPHA_TEST_REF = 3010;

	// Field descriptor #544 I
	public static final int GL_DITHER = 3024;

	// Field descriptor #544 I
	public static final int GL_BLEND_DST = 3040;

	// Field descriptor #544 I
	public static final int GL_BLEND_SRC = 3041;

	// Field descriptor #544 I
	public static final int GL_BLEND = 3042;

	// Field descriptor #544 I
	public static final int GL_LOGIC_OP_MODE = 3056;

	// Field descriptor #544 I
	public static final int GL_INDEX_LOGIC_OP = 3057;

	// Field descriptor #544 I
	public static final int GL_COLOR_LOGIC_OP = 3058;

	// Field descriptor #544 I
	public static final int GL_AUX_BUFFERS = 3072;

	// Field descriptor #544 I
	public static final int GL_DRAW_BUFFER = 3073;

	// Field descriptor #544 I
	public static final int GL_READ_BUFFER = 3074;

	// Field descriptor #544 I
	public static final int GL_SCISSOR_BOX = 3088;

	// Field descriptor #544 I
	public static final int GL_SCISSOR_TEST = 3089;

	// Field descriptor #544 I
	public static final int GL_INDEX_CLEAR_VALUE = 3104;

	// Field descriptor #544 I
	public static final int GL_INDEX_WRITEMASK = 3105;

	// Field descriptor #544 I
	public static final int GL_COLOR_CLEAR_VALUE = 3106;

	// Field descriptor #544 I
	public static final int GL_COLOR_WRITEMASK = 3107;

	// Field descriptor #544 I
	public static final int GL_INDEX_MODE = 3120;

	// Field descriptor #544 I
	public static final int GL_RGBA_MODE = 3121;

	// Field descriptor #544 I
	public static final int GL_DOUBLEBUFFER = 3122;

	// Field descriptor #544 I
	public static final int GL_STEREO = 3123;

	// Field descriptor #544 I
	public static final int GL_RENDER_MODE = 3136;

	// Field descriptor #544 I
	public static final int GL_PERSPECTIVE_CORRECTION_HINT = 3152;

	// Field descriptor #544 I
	public static final int GL_POINT_SMOOTH_HINT = 3153;

	// Field descriptor #544 I
	public static final int GL_LINE_SMOOTH_HINT = 3154;

	// Field descriptor #544 I
	public static final int GL_POLYGON_SMOOTH_HINT = 3155;

	// Field descriptor #544 I
	public static final int GL_FOG_HINT = 3156;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_GEN_S = 3168;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_GEN_T = 3169;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_GEN_R = 3170;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_GEN_Q = 3171;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_I_TO_I = 3184;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_S_TO_S = 3185;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_I_TO_R = 3186;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_I_TO_G = 3187;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_I_TO_B = 3188;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_I_TO_A = 3189;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_R_TO_R = 3190;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_G_TO_G = 3191;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_B_TO_B = 3192;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_A_TO_A = 3193;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_I_TO_I_SIZE = 3248;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_S_TO_S_SIZE = 3249;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_I_TO_R_SIZE = 3250;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_I_TO_G_SIZE = 3251;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_I_TO_B_SIZE = 3252;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_I_TO_A_SIZE = 3253;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_R_TO_R_SIZE = 3254;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_G_TO_G_SIZE = 3255;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_B_TO_B_SIZE = 3256;

	// Field descriptor #544 I
	public static final int GL_PIXEL_MAP_A_TO_A_SIZE = 3257;

	// Field descriptor #544 I
	public static final int GL_UNPACK_SWAP_BYTES = 3312;

	// Field descriptor #544 I
	public static final int GL_UNPACK_LSB_FIRST = 3313;

	// Field descriptor #544 I
	public static final int GL_UNPACK_ROW_LENGTH = 3314;

	// Field descriptor #544 I
	public static final int GL_UNPACK_SKIP_ROWS = 3315;

	// Field descriptor #544 I
	public static final int GL_UNPACK_SKIP_PIXELS = 3316;

	// Field descriptor #544 I
	public static final int GL_UNPACK_ALIGNMENT = 3317;

	// Field descriptor #544 I
	public static final int GL_PACK_SWAP_BYTES = 3328;

	// Field descriptor #544 I
	public static final int GL_PACK_LSB_FIRST = 3329;

	// Field descriptor #544 I
	public static final int GL_PACK_ROW_LENGTH = 3330;

	// Field descriptor #544 I
	public static final int GL_PACK_SKIP_ROWS = 3331;

	// Field descriptor #544 I
	public static final int GL_PACK_SKIP_PIXELS = 3332;

	// Field descriptor #544 I
	public static final int GL_PACK_ALIGNMENT = 3333;

	// Field descriptor #544 I
	public static final int GL_MAP_COLOR = 3344;

	// Field descriptor #544 I
	public static final int GL_MAP_STENCIL = 3345;

	// Field descriptor #544 I
	public static final int GL_INDEX_SHIFT = 3346;

	// Field descriptor #544 I
	public static final int GL_INDEX_OFFSET = 3347;

	// Field descriptor #544 I
	public static final int GL_RED_SCALE = 3348;

	// Field descriptor #544 I
	public static final int GL_RED_BIAS = 3349;

	// Field descriptor #544 I
	public static final int GL_ZOOM_X = 3350;

	// Field descriptor #544 I
	public static final int GL_ZOOM_Y = 3351;

	// Field descriptor #544 I
	public static final int GL_GREEN_SCALE = 3352;

	// Field descriptor #544 I
	public static final int GL_GREEN_BIAS = 3353;

	// Field descriptor #544 I
	public static final int GL_BLUE_SCALE = 3354;

	// Field descriptor #544 I
	public static final int GL_BLUE_BIAS = 3355;

	// Field descriptor #544 I
	public static final int GL_ALPHA_SCALE = 3356;

	// Field descriptor #544 I
	public static final int GL_ALPHA_BIAS = 3357;

	// Field descriptor #544 I
	public static final int GL_DEPTH_SCALE = 3358;

	// Field descriptor #544 I
	public static final int GL_DEPTH_BIAS = 3359;

	// Field descriptor #544 I
	public static final int GL_MAX_EVAL_ORDER = 3376;

	// Field descriptor #544 I
	public static final int GL_MAX_LIGHTS = 3377;

	// Field descriptor #544 I
	public static final int GL_MAX_CLIP_PLANES = 3378;

	// Field descriptor #544 I
	public static final int GL_MAX_TEXTURE_SIZE = 3379;

	// Field descriptor #544 I
	public static final int GL_MAX_PIXEL_MAP_TABLE = 3380;

	// Field descriptor #544 I
	public static final int GL_MAX_ATTRIB_STACK_DEPTH = 3381;

	// Field descriptor #544 I
	public static final int GL_MAX_MODELVIEW_STACK_DEPTH = 3382;

	// Field descriptor #544 I
	public static final int GL_MAX_NAME_STACK_DEPTH = 3383;

	// Field descriptor #544 I
	public static final int GL_MAX_PROJECTION_STACK_DEPTH = 3384;

	// Field descriptor #544 I
	public static final int GL_MAX_TEXTURE_STACK_DEPTH = 3385;

	// Field descriptor #544 I
	public static final int GL_MAX_VIEWPORT_DIMS = 3386;

	// Field descriptor #544 I
	public static final int GL_MAX_CLIENT_ATTRIB_STACK_DEPTH = 3387;

	// Field descriptor #544 I
	public static final int GL_SUBPIXEL_BITS = 3408;

	// Field descriptor #544 I
	public static final int GL_INDEX_BITS = 3409;

	// Field descriptor #544 I
	public static final int GL_RED_BITS = 3410;

	// Field descriptor #544 I
	public static final int GL_GREEN_BITS = 3411;

	// Field descriptor #544 I
	public static final int GL_BLUE_BITS = 3412;

	// Field descriptor #544 I
	public static final int GL_ALPHA_BITS = 3413;

	// Field descriptor #544 I
	public static final int GL_DEPTH_BITS = 3414;

	// Field descriptor #544 I
	public static final int GL_STENCIL_BITS = 3415;

	// Field descriptor #544 I
	public static final int GL_ACCUM_RED_BITS = 3416;

	// Field descriptor #544 I
	public static final int GL_ACCUM_GREEN_BITS = 3417;

	// Field descriptor #544 I
	public static final int GL_ACCUM_BLUE_BITS = 3418;

	// Field descriptor #544 I
	public static final int GL_ACCUM_ALPHA_BITS = 3419;

	// Field descriptor #544 I
	public static final int GL_NAME_STACK_DEPTH = 3440;

	// Field descriptor #544 I
	public static final int GL_AUTO_NORMAL = 3456;

	// Field descriptor #544 I
	public static final int GL_MAP1_COLOR_4 = 3472;

	// Field descriptor #544 I
	public static final int GL_MAP1_INDEX = 3473;

	// Field descriptor #544 I
	public static final int GL_MAP1_NORMAL = 3474;

	// Field descriptor #544 I
	public static final int GL_MAP1_TEXTURE_COORD_1 = 3475;

	// Field descriptor #544 I
	public static final int GL_MAP1_TEXTURE_COORD_2 = 3476;

	// Field descriptor #544 I
	public static final int GL_MAP1_TEXTURE_COORD_3 = 3477;

	// Field descriptor #544 I
	public static final int GL_MAP1_TEXTURE_COORD_4 = 3478;

	// Field descriptor #544 I
	public static final int GL_MAP1_VERTEX_3 = 3479;

	// Field descriptor #544 I
	public static final int GL_MAP1_VERTEX_4 = 3480;

	// Field descriptor #544 I
	public static final int GL_MAP2_COLOR_4 = 3504;

	// Field descriptor #544 I
	public static final int GL_MAP2_INDEX = 3505;

	// Field descriptor #544 I
	public static final int GL_MAP2_NORMAL = 3506;

	// Field descriptor #544 I
	public static final int GL_MAP2_TEXTURE_COORD_1 = 3507;

	// Field descriptor #544 I
	public static final int GL_MAP2_TEXTURE_COORD_2 = 3508;

	// Field descriptor #544 I
	public static final int GL_MAP2_TEXTURE_COORD_3 = 3509;

	// Field descriptor #544 I
	public static final int GL_MAP2_TEXTURE_COORD_4 = 3510;

	// Field descriptor #544 I
	public static final int GL_MAP2_VERTEX_3 = 3511;

	// Field descriptor #544 I
	public static final int GL_MAP2_VERTEX_4 = 3512;

	// Field descriptor #544 I
	public static final int GL_MAP1_GRID_DOMAIN = 3536;

	// Field descriptor #544 I
	public static final int GL_MAP1_GRID_SEGMENTS = 3537;

	// Field descriptor #544 I
	public static final int GL_MAP2_GRID_DOMAIN = 3538;

	// Field descriptor #544 I
	public static final int GL_MAP2_GRID_SEGMENTS = 3539;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_1D = 3552;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_2D = 3553;

	// Field descriptor #544 I
	public static final int GL_FEEDBACK_BUFFER_POINTER = 3568;

	// Field descriptor #544 I
	public static final int GL_FEEDBACK_BUFFER_SIZE = 3569;

	// Field descriptor #544 I
	public static final int GL_FEEDBACK_BUFFER_TYPE = 3570;

	// Field descriptor #544 I
	public static final int GL_SELECTION_BUFFER_POINTER = 3571;

	// Field descriptor #544 I
	public static final int GL_SELECTION_BUFFER_SIZE = 3572;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_WIDTH = 4096;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_HEIGHT = 4097;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_INTERNAL_FORMAT = 4099;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_BORDER_COLOR = 4100;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_BORDER = 4101;

	// Field descriptor #544 I
	public static final int GL_DONT_CARE = 4352;

	// Field descriptor #544 I
	public static final int GL_FASTEST = 4353;

	// Field descriptor #544 I
	public static final int GL_NICEST = 4354;

	// Field descriptor #544 I
	public static final int GL_LIGHT0 = 16384;

	// Field descriptor #544 I
	public static final int GL_LIGHT1 = 16385;

	// Field descriptor #544 I
	public static final int GL_LIGHT2 = 16386;

	// Field descriptor #544 I
	public static final int GL_LIGHT3 = 16387;

	// Field descriptor #544 I
	public static final int GL_LIGHT4 = 16388;

	// Field descriptor #544 I
	public static final int GL_LIGHT5 = 16389;

	// Field descriptor #544 I
	public static final int GL_LIGHT6 = 16390;

	// Field descriptor #544 I
	public static final int GL_LIGHT7 = 16391;

	// Field descriptor #544 I
	public static final int GL_AMBIENT = 4608;

	// Field descriptor #544 I
	public static final int GL_DIFFUSE = 4609;

	// Field descriptor #544 I
	public static final int GL_SPECULAR = 4610;

	// Field descriptor #544 I
	public static final int GL_POSITION = 4611;

	// Field descriptor #544 I
	public static final int GL_SPOT_DIRECTION = 4612;

	// Field descriptor #544 I
	public static final int GL_SPOT_EXPONENT = 4613;

	// Field descriptor #544 I
	public static final int GL_SPOT_CUTOFF = 4614;

	// Field descriptor #544 I
	public static final int GL_CONSTANT_ATTENUATION = 4615;

	// Field descriptor #544 I
	public static final int GL_LINEAR_ATTENUATION = 4616;

	// Field descriptor #544 I
	public static final int GL_QUADRATIC_ATTENUATION = 4617;

	// Field descriptor #544 I
	public static final int GL_COMPILE = 4864;

	// Field descriptor #544 I
	public static final int GL_COMPILE_AND_EXECUTE = 4865;

	// Field descriptor #544 I
	public static final int GL_CLEAR = 5376;

	// Field descriptor #544 I
	public static final int GL_AND = 5377;

	// Field descriptor #544 I
	public static final int GL_AND_REVERSE = 5378;

	// Field descriptor #544 I
	public static final int GL_COPY = 5379;

	// Field descriptor #544 I
	public static final int GL_AND_INVERTED = 5380;

	// Field descriptor #544 I
	public static final int GL_NOOP = 5381;

	// Field descriptor #544 I
	public static final int GL_XOR = 5382;

	// Field descriptor #544 I
	public static final int GL_OR = 5383;

	// Field descriptor #544 I
	public static final int GL_NOR = 5384;

	// Field descriptor #544 I
	public static final int GL_EQUIV = 5385;

	// Field descriptor #544 I
	public static final int GL_INVERT = 5386;

	// Field descriptor #544 I
	public static final int GL_OR_REVERSE = 5387;

	// Field descriptor #544 I
	public static final int GL_COPY_INVERTED = 5388;

	// Field descriptor #544 I
	public static final int GL_OR_INVERTED = 5389;

	// Field descriptor #544 I
	public static final int GL_NAND = 5390;

	// Field descriptor #544 I
	public static final int GL_SET = 5391;

	// Field descriptor #544 I
	public static final int GL_EMISSION = 5632;

	// Field descriptor #544 I
	public static final int GL_SHININESS = 5633;

	// Field descriptor #544 I
	public static final int GL_AMBIENT_AND_DIFFUSE = 5634;

	// Field descriptor #544 I
	public static final int GL_COLOR_INDEXES = 5635;

	// Field descriptor #544 I
	public static final int GL_MODELVIEW = 5888;

	// Field descriptor #544 I
	public static final int GL_PROJECTION = 5889;

	// Field descriptor #544 I
	public static final int GL_TEXTURE = 5890;

	// Field descriptor #544 I
	public static final int GL_COLOR = 6144;

	// Field descriptor #544 I
	public static final int GL_DEPTH = 6145;

	// Field descriptor #544 I
	public static final int GL_STENCIL = 6146;

	// Field descriptor #544 I
	public static final int GL_COLOR_INDEX = 6400;

	// Field descriptor #544 I
	public static final int GL_STENCIL_INDEX = 6401;

	// Field descriptor #544 I
	public static final int GL_DEPTH_COMPONENT = 6402;

	// Field descriptor #544 I
	public static final int GL_RED = 6403;

	// Field descriptor #544 I
	public static final int GL_GREEN = 6404;

	// Field descriptor #544 I
	public static final int GL_BLUE = 6405;

	// Field descriptor #544 I
	public static final int GL_ALPHA = 6406;

	// Field descriptor #544 I
	public static final int GL_RGB = 6407;

	// Field descriptor #544 I
	public static final int GL_RGBA = 6408;

	// Field descriptor #544 I
	public static final int GL_LUMINANCE = 6409;

	// Field descriptor #544 I
	public static final int GL_LUMINANCE_ALPHA = 6410;

	// Field descriptor #544 I
	public static final int GL_BITMAP = 6656;

	// Field descriptor #544 I
	public static final int GL_POINT = 6912;

	// Field descriptor #544 I
	public static final int GL_LINE = 6913;

	// Field descriptor #544 I
	public static final int GL_FILL = 6914;

	// Field descriptor #544 I
	public static final int GL_RENDER = 7168;

	// Field descriptor #544 I
	public static final int GL_FEEDBACK = 7169;

	// Field descriptor #544 I
	public static final int GL_SELECT = 7170;

	// Field descriptor #544 I
	public static final int GL_FLAT = 7424;

	// Field descriptor #544 I
	public static final int GL_SMOOTH = 7425;

	// Field descriptor #544 I
	public static final int GL_KEEP = 7680;

	// Field descriptor #544 I
	public static final int GL_REPLACE = 7681;

	// Field descriptor #544 I
	public static final int GL_INCR = 7682;

	// Field descriptor #544 I
	public static final int GL_DECR = 7683;

	// Field descriptor #544 I
	public static final int GL_VENDOR = 7936;

	// Field descriptor #544 I
	public static final int GL_RENDERER = 7937;

	// Field descriptor #544 I
	public static final int GL_VERSION = 7938;

	// Field descriptor #544 I
	public static final int GL_EXTENSIONS = 7939;

	// Field descriptor #544 I
	public static final int GL_S = 8192;

	// Field descriptor #544 I
	public static final int GL_T = 8193;

	// Field descriptor #544 I
	public static final int GL_R = 8194;

	// Field descriptor #544 I
	public static final int GL_Q = 8195;

	// Field descriptor #544 I
	public static final int GL_MODULATE = 8448;

	// Field descriptor #544 I
	public static final int GL_DECAL = 8449;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_ENV_MODE = 8704;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_ENV_COLOR = 8705;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_ENV = 8960;

	// Field descriptor #544 I
	public static final int GL_EYE_LINEAR = 9216;

	// Field descriptor #544 I
	public static final int GL_OBJECT_LINEAR = 9217;

	// Field descriptor #544 I
	public static final int GL_SPHERE_MAP = 9218;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_GEN_MODE = 9472;

	// Field descriptor #544 I
	public static final int GL_OBJECT_PLANE = 9473;

	// Field descriptor #544 I
	public static final int GL_EYE_PLANE = 9474;

	// Field descriptor #544 I
	public static final int GL_NEAREST = 9728;

	// Field descriptor #544 I
	public static final int GL_LINEAR = 9729;

	// Field descriptor #544 I
	public static final int GL_NEAREST_MIPMAP_NEAREST = 9984;

	// Field descriptor #544 I
	public static final int GL_LINEAR_MIPMAP_NEAREST = 9985;

	// Field descriptor #544 I
	public static final int GL_NEAREST_MIPMAP_LINEAR = 9986;

	// Field descriptor #544 I
	public static final int GL_LINEAR_MIPMAP_LINEAR = 9987;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_MAG_FILTER = 10240;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_MIN_FILTER = 10241;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_WRAP_S = 10242;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_WRAP_T = 10243;

	// Field descriptor #544 I
	public static final int GL_CLAMP = 10496;

	// Field descriptor #544 I
	public static final int GL_REPEAT = 10497;

	// Field descriptor #544 I
	public static final int GL_CLIENT_PIXEL_STORE_BIT = 1;

	// Field descriptor #544 I
	public static final int GL_CLIENT_VERTEX_ARRAY_BIT = 2;

	// Field descriptor #544 I
	public static final int GL_ALL_CLIENT_ATTRIB_BITS = -1;

	// Field descriptor #544 I
	public static final int GL_POLYGON_OFFSET_FACTOR = 32824;

	// Field descriptor #544 I
	public static final int GL_POLYGON_OFFSET_UNITS = 10752;

	// Field descriptor #544 I
	public static final int GL_POLYGON_OFFSET_POINT = 10753;

	// Field descriptor #544 I
	public static final int GL_POLYGON_OFFSET_LINE = 10754;

	// Field descriptor #544 I
	public static final int GL_POLYGON_OFFSET_FILL = 32823;

	// Field descriptor #544 I
	public static final int GL_ALPHA4 = 32827;

	// Field descriptor #544 I
	public static final int GL_ALPHA8 = 32828;

	// Field descriptor #544 I
	public static final int GL_ALPHA12 = 32829;

	// Field descriptor #544 I
	public static final int GL_ALPHA16 = 32830;

	// Field descriptor #544 I
	public static final int GL_LUMINANCE4 = 32831;

	// Field descriptor #544 I
	public static final int GL_LUMINANCE8 = 32832;

	// Field descriptor #544 I
	public static final int GL_LUMINANCE12 = 32833;

	// Field descriptor #544 I
	public static final int GL_LUMINANCE16 = 32834;

	// Field descriptor #544 I
	public static final int GL_LUMINANCE4_ALPHA4 = 32835;

	// Field descriptor #544 I
	public static final int GL_LUMINANCE6_ALPHA2 = 32836;

	// Field descriptor #544 I
	public static final int GL_LUMINANCE8_ALPHA8 = 32837;

	// Field descriptor #544 I
	public static final int GL_LUMINANCE12_ALPHA4 = 32838;

	// Field descriptor #544 I
	public static final int GL_LUMINANCE12_ALPHA12 = 32839;

	// Field descriptor #544 I
	public static final int GL_LUMINANCE16_ALPHA16 = 32840;

	// Field descriptor #544 I
	public static final int GL_INTENSITY = 32841;

	// Field descriptor #544 I
	public static final int GL_INTENSITY4 = 32842;

	// Field descriptor #544 I
	public static final int GL_INTENSITY8 = 32843;

	// Field descriptor #544 I
	public static final int GL_INTENSITY12 = 32844;

	// Field descriptor #544 I
	public static final int GL_INTENSITY16 = 32845;

	// Field descriptor #544 I
	public static final int GL_R3_G3_B2 = 10768;

	// Field descriptor #544 I
	public static final int GL_RGB4 = 32847;

	// Field descriptor #544 I
	public static final int GL_RGB5 = 32848;

	// Field descriptor #544 I
	public static final int GL_RGB8 = 32849;

	// Field descriptor #544 I
	public static final int GL_RGB10 = 32850;

	// Field descriptor #544 I
	public static final int GL_RGB12 = 32851;

	// Field descriptor #544 I
	public static final int GL_RGB16 = 32852;

	// Field descriptor #544 I
	public static final int GL_RGBA2 = 32853;

	// Field descriptor #544 I
	public static final int GL_RGBA4 = 32854;

	// Field descriptor #544 I
	public static final int GL_RGB5_A1 = 32855;

	// Field descriptor #544 I
	public static final int GL_RGBA8 = 32856;

	// Field descriptor #544 I
	public static final int GL_RGB10_A2 = 32857;

	// Field descriptor #544 I
	public static final int GL_RGBA12 = 32858;

	// Field descriptor #544 I
	public static final int GL_RGBA16 = 32859;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_RED_SIZE = 32860;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_GREEN_SIZE = 32861;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_BLUE_SIZE = 32862;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_ALPHA_SIZE = 32863;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_LUMINANCE_SIZE = 32864;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_INTENSITY_SIZE = 32865;

	// Field descriptor #544 I
	public static final int GL_PROXY_TEXTURE_1D = 32867;

	// Field descriptor #544 I
	public static final int GL_PROXY_TEXTURE_2D = 32868;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_PRIORITY = 32870;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_RESIDENT = 32871;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_BINDING_1D = 32872;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_BINDING_2D = 32873;

	// Field descriptor #544 I
	public static final int GL_VERTEX_ARRAY = 32884;

	// Field descriptor #544 I
	public static final int GL_NORMAL_ARRAY = 32885;

	// Field descriptor #544 I
	public static final int GL_COLOR_ARRAY = 32886;

	// Field descriptor #544 I
	public static final int GL_INDEX_ARRAY = 32887;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_COORD_ARRAY = 32888;

	// Field descriptor #544 I
	public static final int GL_EDGE_FLAG_ARRAY = 32889;

	// Field descriptor #544 I
	public static final int GL_VERTEX_ARRAY_SIZE = 32890;

	// Field descriptor #544 I
	public static final int GL_VERTEX_ARRAY_TYPE = 32891;

	// Field descriptor #544 I
	public static final int GL_VERTEX_ARRAY_STRIDE = 32892;

	// Field descriptor #544 I
	public static final int GL_NORMAL_ARRAY_TYPE = 32894;

	// Field descriptor #544 I
	public static final int GL_NORMAL_ARRAY_STRIDE = 32895;

	// Field descriptor #544 I
	public static final int GL_COLOR_ARRAY_SIZE = 32897;

	// Field descriptor #544 I
	public static final int GL_COLOR_ARRAY_TYPE = 32898;

	// Field descriptor #544 I
	public static final int GL_COLOR_ARRAY_STRIDE = 32899;

	// Field descriptor #544 I
	public static final int GL_INDEX_ARRAY_TYPE = 32901;

	// Field descriptor #544 I
	public static final int GL_INDEX_ARRAY_STRIDE = 32902;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_COORD_ARRAY_SIZE = 32904;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_COORD_ARRAY_TYPE = 32905;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_COORD_ARRAY_STRIDE = 32906;

	// Field descriptor #544 I
	public static final int GL_EDGE_FLAG_ARRAY_STRIDE = 32908;

	// Field descriptor #544 I
	public static final int GL_VERTEX_ARRAY_POINTER = 32910;

	// Field descriptor #544 I
	public static final int GL_NORMAL_ARRAY_POINTER = 32911;

	// Field descriptor #544 I
	public static final int GL_COLOR_ARRAY_POINTER = 32912;

	// Field descriptor #544 I
	public static final int GL_INDEX_ARRAY_POINTER = 32913;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_COORD_ARRAY_POINTER = 32914;

	// Field descriptor #544 I
	public static final int GL_EDGE_FLAG_ARRAY_POINTER = 32915;

	// Field descriptor #544 I
	public static final int GL_V2F = 10784;

	// Field descriptor #544 I
	public static final int GL_V3F = 10785;

	// Field descriptor #544 I
	public static final int GL_C4UB_V2F = 10786;

	// Field descriptor #544 I
	public static final int GL_C4UB_V3F = 10787;

	// Field descriptor #544 I
	public static final int GL_C3F_V3F = 10788;

	// Field descriptor #544 I
	public static final int GL_N3F_V3F = 10789;

	// Field descriptor #544 I
	public static final int GL_C4F_N3F_V3F = 10790;

	// Field descriptor #544 I
	public static final int GL_T2F_V3F = 10791;

	// Field descriptor #544 I
	public static final int GL_T4F_V4F = 10792;

	// Field descriptor #544 I
	public static final int GL_T2F_C4UB_V3F = 10793;

	// Field descriptor #544 I
	public static final int GL_T2F_C3F_V3F = 10794;

	// Field descriptor #544 I
	public static final int GL_T2F_N3F_V3F = 10795;

	// Field descriptor #544 I
	public static final int GL_T2F_C4F_N3F_V3F = 10796;

	// Field descriptor #544 I
	public static final int GL_T4F_C4F_N3F_V4F = 10797;

	// Field descriptor #544 I
	public static final int GL_LOGIC_OP = 3057;

	// Field descriptor #544 I
	public static final int GL_TEXTURE_COMPONENTS = 4099;

	// Field descriptor #45 I
	public static final int GL_TEXTURE_BINDING_3D = 32874;

	// Field descriptor #45 I
	public static final int GL_PACK_SKIP_IMAGES = 32875;

	// Field descriptor #45 I
	public static final int GL_PACK_IMAGE_HEIGHT = 32876;

	// Field descriptor #45 I
	public static final int GL_UNPACK_SKIP_IMAGES = 32877;

	// Field descriptor #45 I
	public static final int GL_UNPACK_IMAGE_HEIGHT = 32878;

	// Field descriptor #45 I
	public static final int GL_TEXTURE_3D = 32879;

	// Field descriptor #45 I
	public static final int GL_PROXY_TEXTURE_3D = 32880;

	// Field descriptor #45 I
	public static final int GL_TEXTURE_DEPTH = 32881;

	// Field descriptor #45 I
	public static final int GL_TEXTURE_WRAP_R = 32882;

	// Field descriptor #45 I
	public static final int GL_MAX_3D_TEXTURE_SIZE = 32883;

	// Field descriptor #45 I
	public static final int GL_BGR = 32992;

	// Field descriptor #45 I
	public static final int GL_BGRA = 32993;

	// Field descriptor #45 I
	public static final int GL_UNSIGNED_BYTE_3_3_2 = 32818;

	// Field descriptor #45 I
	public static final int GL_UNSIGNED_BYTE_2_3_3_REV = 33634;

	// Field descriptor #45 I
	public static final int GL_UNSIGNED_SHORT_5_6_5 = 33635;

	// Field descriptor #45 I
	public static final int GL_UNSIGNED_SHORT_5_6_5_REV = 33636;

	// Field descriptor #45 I
	public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 32819;

	// Field descriptor #45 I
	public static final int GL_UNSIGNED_SHORT_4_4_4_4_REV = 33637;

	// Field descriptor #45 I
	public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 32820;

	// Field descriptor #45 I
	public static final int GL_UNSIGNED_SHORT_1_5_5_5_REV = 33638;

	// Field descriptor #45 I
	public static final int GL_UNSIGNED_INT_8_8_8_8 = 32821;

	// Field descriptor #45 I
	public static final int GL_UNSIGNED_INT_8_8_8_8_REV = 33639;

	// Field descriptor #45 I
	public static final int GL_UNSIGNED_INT_10_10_10_2 = 32822;

	// Field descriptor #45 I
	public static final int GL_UNSIGNED_INT_2_10_10_10_REV = 33640;

	// Field descriptor #45 I
	public static final int GL_RESCALE_NORMAL = 32826;

	// Field descriptor #45 I
	public static final int GL_LIGHT_MODEL_COLOR_CONTROL = 33272;

	// Field descriptor #45 I
	public static final int GL_SINGLE_COLOR = 33273;

	// Field descriptor #45 I
	public static final int GL_SEPARATE_SPECULAR_COLOR = 33274;

	// Field descriptor #45 I
	public static final int GL_CLAMP_TO_EDGE = 33071;

	// Field descriptor #45 I
	public static final int GL_TEXTURE_MIN_LOD = 33082;

	// Field descriptor #45 I
	public static final int GL_TEXTURE_MAX_LOD = 33083;

	// Field descriptor #45 I
	public static final int GL_TEXTURE_BASE_LEVEL = 33084;

	// Field descriptor #45 I
	public static final int GL_TEXTURE_MAX_LEVEL = 33085;

	// Field descriptor #45 I
	public static final int GL_MAX_ELEMENTS_VERTICES = 33000;

	// Field descriptor #45 I
	public static final int GL_MAX_ELEMENTS_INDICES = 33001;

	// Field descriptor #45 I
	public static final int GL_ALIASED_POINT_SIZE_RANGE = 33901;

	// Field descriptor #45 I
	public static final int GL_ALIASED_LINE_WIDTH_RANGE = 33902;

	// Field descriptor #45 I
	public static final int GL_SMOOTH_POINT_SIZE_RANGE = 2834;

	// Field descriptor #45 I
	public static final int GL_SMOOTH_POINT_SIZE_GRANULARITY = 2835;

	// Field descriptor #45 I
	public static final int GL_SMOOTH_LINE_WIDTH_RANGE = 2850;

	// Field descriptor #45 I
	public static final int GL_SMOOTH_LINE_WIDTH_GRANULARITY = 2851;

	// Field descriptor #76 I
	public static final int GL_TEXTURE0 = 33984;

	// Field descriptor #76 I
	public static final int GL_TEXTURE1 = 33985;

	// Field descriptor #76 I
	public static final int GL_TEXTURE2 = 33986;

	// Field descriptor #76 I
	public static final int GL_TEXTURE3 = 33987;

	// Field descriptor #76 I
	public static final int GL_TEXTURE4 = 33988;

	// Field descriptor #76 I
	public static final int GL_TEXTURE5 = 33989;

	// Field descriptor #76 I
	public static final int GL_TEXTURE6 = 33990;

	// Field descriptor #76 I
	public static final int GL_TEXTURE7 = 33991;

	// Field descriptor #76 I
	public static final int GL_TEXTURE8 = 33992;

	// Field descriptor #76 I
	public static final int GL_TEXTURE9 = 33993;

	// Field descriptor #76 I
	public static final int GL_TEXTURE10 = 33994;

	// Field descriptor #76 I
	public static final int GL_TEXTURE11 = 33995;

	// Field descriptor #76 I
	public static final int GL_TEXTURE12 = 33996;

	// Field descriptor #76 I
	public static final int GL_TEXTURE13 = 33997;

	// Field descriptor #76 I
	public static final int GL_TEXTURE14 = 33998;

	// Field descriptor #76 I
	public static final int GL_TEXTURE15 = 33999;

	// Field descriptor #76 I
	public static final int GL_TEXTURE16 = 34000;

	// Field descriptor #76 I
	public static final int GL_TEXTURE17 = 34001;

	// Field descriptor #76 I
	public static final int GL_TEXTURE18 = 34002;

	// Field descriptor #76 I
	public static final int GL_TEXTURE19 = 34003;

	// Field descriptor #76 I
	public static final int GL_TEXTURE20 = 34004;

	// Field descriptor #76 I
	public static final int GL_TEXTURE21 = 34005;

	// Field descriptor #76 I
	public static final int GL_TEXTURE22 = 34006;

	// Field descriptor #76 I
	public static final int GL_TEXTURE23 = 34007;

	// Field descriptor #76 I
	public static final int GL_TEXTURE24 = 34008;

	// Field descriptor #76 I
	public static final int GL_TEXTURE25 = 34009;

	// Field descriptor #76 I
	public static final int GL_TEXTURE26 = 34010;

	// Field descriptor #76 I
	public static final int GL_TEXTURE27 = 34011;

	// Field descriptor #76 I
	public static final int GL_TEXTURE28 = 34012;

	// Field descriptor #76 I
	public static final int GL_TEXTURE29 = 34013;

	// Field descriptor #76 I
	public static final int GL_TEXTURE30 = 34014;

	// Field descriptor #76 I
	public static final int GL_TEXTURE31 = 34015;

	// Field descriptor #76 I
	public static final int GL_ACTIVE_TEXTURE = 34016;

	// Field descriptor #76 I
	public static final int GL_CLIENT_ACTIVE_TEXTURE = 34017;

	// Field descriptor #76 I
	public static final int GL_MAX_TEXTURE_UNITS = 34018;

	// Field descriptor #76 I
	public static final int GL_NORMAL_MAP = 34065;

	// Field descriptor #76 I
	public static final int GL_REFLECTION_MAP = 34066;

	// Field descriptor #76 I
	public static final int GL_TEXTURE_CUBE_MAP = 34067;

	// Field descriptor #76 I
	public static final int GL_TEXTURE_BINDING_CUBE_MAP = 34068;

	// Field descriptor #76 I
	public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 34069;

	// Field descriptor #76 I
	public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 34070;

	// Field descriptor #76 I
	public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 34071;

	// Field descriptor #76 I
	public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 34072;

	// Field descriptor #76 I
	public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 34073;

	// Field descriptor #76 I
	public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 34074;

	// Field descriptor #76 I
	public static final int GL_PROXY_TEXTURE_CUBE_MAP = 34075;

	// Field descriptor #76 I
	public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 34076;

	// Field descriptor #76 I
	public static final int GL_COMPRESSED_ALPHA = 34025;

	// Field descriptor #76 I
	public static final int GL_COMPRESSED_LUMINANCE = 34026;

	// Field descriptor #76 I
	public static final int GL_COMPRESSED_LUMINANCE_ALPHA = 34027;

	// Field descriptor #76 I
	public static final int GL_COMPRESSED_INTENSITY = 34028;

	// Field descriptor #76 I
	public static final int GL_COMPRESSED_RGB = 34029;

	// Field descriptor #76 I
	public static final int GL_COMPRESSED_RGBA = 34030;

	// Field descriptor #76 I
	public static final int GL_TEXTURE_COMPRESSION_HINT = 34031;

	// Field descriptor #76 I
	public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE = 34464;

	// Field descriptor #76 I
	public static final int GL_TEXTURE_COMPRESSED = 34465;

	// Field descriptor #76 I
	public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 34466;

	// Field descriptor #76 I
	public static final int GL_COMPRESSED_TEXTURE_FORMATS = 34467;

	// Field descriptor #76 I
	public static final int GL_MULTISAMPLE = 32925;

	// Field descriptor #76 I
	public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 32926;

	// Field descriptor #76 I
	public static final int GL_SAMPLE_ALPHA_TO_ONE = 32927;

	// Field descriptor #76 I
	public static final int GL_SAMPLE_COVERAGE = 32928;

	// Field descriptor #76 I
	public static final int GL_SAMPLE_BUFFERS = 32936;

	// Field descriptor #76 I
	public static final int GL_SAMPLES = 32937;

	// Field descriptor #76 I
	public static final int GL_SAMPLE_COVERAGE_VALUE = 32938;

	// Field descriptor #76 I
	public static final int GL_SAMPLE_COVERAGE_INVERT = 32939;

	// Field descriptor #76 I
	public static final int GL_MULTISAMPLE_BIT = 536870912;

	// Field descriptor #76 I
	public static final int GL_TRANSPOSE_MODELVIEW_MATRIX = 34019;

	// Field descriptor #76 I
	public static final int GL_TRANSPOSE_PROJECTION_MATRIX = 34020;

	// Field descriptor #76 I
	public static final int GL_TRANSPOSE_TEXTURE_MATRIX = 34021;

	// Field descriptor #76 I
	public static final int GL_TRANSPOSE_COLOR_MATRIX = 34022;

	// Field descriptor #76 I
	public static final int GL_COMBINE = 34160;

	// Field descriptor #76 I
	public static final int GL_COMBINE_RGB = 34161;

	// Field descriptor #76 I
	public static final int GL_COMBINE_ALPHA = 34162;

	// Field descriptor #76 I
	public static final int GL_SOURCE0_RGB = 34176;

	// Field descriptor #76 I
	public static final int GL_SOURCE1_RGB = 34177;

	// Field descriptor #76 I
	public static final int GL_SOURCE2_RGB = 34178;

	// Field descriptor #76 I
	public static final int GL_SOURCE0_ALPHA = 34184;

	// Field descriptor #76 I
	public static final int GL_SOURCE1_ALPHA = 34185;

	// Field descriptor #76 I
	public static final int GL_SOURCE2_ALPHA = 34186;

	// Field descriptor #76 I
	public static final int GL_OPERAND0_RGB = 34192;

	// Field descriptor #76 I
	public static final int GL_OPERAND1_RGB = 34193;

	// Field descriptor #76 I
	public static final int GL_OPERAND2_RGB = 34194;

	// Field descriptor #76 I
	public static final int GL_OPERAND0_ALPHA = 34200;

	// Field descriptor #76 I
	public static final int GL_OPERAND1_ALPHA = 34201;

	// Field descriptor #76 I
	public static final int GL_OPERAND2_ALPHA = 34202;

	// Field descriptor #76 I
	public static final int GL_RGB_SCALE = 34163;

	// Field descriptor #76 I
	public static final int GL_ADD_SIGNED = 34164;

	// Field descriptor #76 I
	public static final int GL_INTERPOLATE = 34165;

	// Field descriptor #76 I
	public static final int GL_SUBTRACT = 34023;

	// Field descriptor #76 I
	public static final int GL_CONSTANT = 34166;

	// Field descriptor #76 I
	public static final int GL_PRIMARY_COLOR = 34167;

	// Field descriptor #76 I
	public static final int GL_PREVIOUS = 34168;

	// Field descriptor #76 I
	public static final int GL_DOT3_RGB = 34478;

	// Field descriptor #76 I
	public static final int GL_DOT3_RGBA = 34479;

	// Field descriptor #76 I
	public static final int GL_CLAMP_TO_BORDER = 33069;

	// Field descriptor #71 I
	public static final int GL_ARRAY_BUFFER = 34962;

	// Field descriptor #71 I
	public static final int GL_ELEMENT_ARRAY_BUFFER = 34963;

	// Field descriptor #71 I
	public static final int GL_ARRAY_BUFFER_BINDING = 34964;

	// Field descriptor #71 I
	public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965;

	// Field descriptor #71 I
	public static final int GL_VERTEX_ARRAY_BUFFER_BINDING = 34966;

	// Field descriptor #71 I
	public static final int GL_NORMAL_ARRAY_BUFFER_BINDING = 34967;

	// Field descriptor #71 I
	public static final int GL_COLOR_ARRAY_BUFFER_BINDING = 34968;

	// Field descriptor #71 I
	public static final int GL_INDEX_ARRAY_BUFFER_BINDING = 34969;

	// Field descriptor #71 I
	public static final int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING = 34970;

	// Field descriptor #71 I
	public static final int GL_EDGE_FLAG_ARRAY_BUFFER_BINDING = 34971;

	// Field descriptor #71 I
	public static final int GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING = 34972;

	// Field descriptor #71 I
	public static final int GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING = 34973;

	// Field descriptor #71 I
	public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING = 34974;

	// Field descriptor #71 I
	public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 34975;

	// Field descriptor #71 I
	public static final int GL_STREAM_DRAW = 35040;

	// Field descriptor #71 I
	public static final int GL_STREAM_READ = 35041;

	// Field descriptor #71 I
	public static final int GL_STREAM_COPY = 35042;

	// Field descriptor #71 I
	public static final int GL_STATIC_DRAW = 35044;

	// Field descriptor #71 I
	public static final int GL_STATIC_READ = 35045;

	// Field descriptor #71 I
	public static final int GL_STATIC_COPY = 35046;

	// Field descriptor #71 I
	public static final int GL_DYNAMIC_DRAW = 35048;

	// Field descriptor #71 I
	public static final int GL_DYNAMIC_READ = 35049;

	// Field descriptor #71 I
	public static final int GL_DYNAMIC_COPY = 35050;

	// Field descriptor #71 I
	public static final int GL_READ_ONLY = 35000;

	// Field descriptor #71 I
	public static final int GL_WRITE_ONLY = 35001;

	// Field descriptor #71 I
	public static final int GL_READ_WRITE = 35002;

	// Field descriptor #71 I
	public static final int GL_BUFFER_SIZE = 34660;

	// Field descriptor #71 I
	public static final int GL_BUFFER_USAGE = 34661;

	// Field descriptor #71 I
	public static final int GL_BUFFER_ACCESS = 35003;

	// Field descriptor #71 I
	public static final int GL_BUFFER_MAPPED = 35004;

	// Field descriptor #71 I
	public static final int GL_BUFFER_MAP_POINTER = 35005;

	// Field descriptor #71 I
	public static final int GL_FOG_COORD_SRC = 33872;

	// Field descriptor #71 I
	public static final int GL_FOG_COORD = 33873;

	// Field descriptor #71 I
	public static final int GL_CURRENT_FOG_COORD = 33875;

	// Field descriptor #71 I
	public static final int GL_FOG_COORD_ARRAY_TYPE = 33876;

	// Field descriptor #71 I
	public static final int GL_FOG_COORD_ARRAY_STRIDE = 33877;

	// Field descriptor #71 I
	public static final int GL_FOG_COORD_ARRAY_POINTER = 33878;

	// Field descriptor #71 I
	public static final int GL_FOG_COORD_ARRAY = 33879;

	// Field descriptor #71 I
	public static final int GL_FOG_COORD_ARRAY_BUFFER_BINDING = 34973;

	// Field descriptor #71 I
	public static final int GL_SRC0_RGB = 34176;

	// Field descriptor #71 I
	public static final int GL_SRC1_RGB = 34177;

	// Field descriptor #71 I
	public static final int GL_SRC2_RGB = 34178;

	// Field descriptor #71 I
	public static final int GL_SRC0_ALPHA = 34184;

	// Field descriptor #71 I
	public static final int GL_SRC1_ALPHA = 34185;

	// Field descriptor #71 I
	public static final int GL_SRC2_ALPHA = 34186;

	// Field descriptor #71 I
	public static final int GL_SAMPLES_PASSED = 35092;

	// Field descriptor #71 I
	public static final int GL_QUERY_COUNTER_BITS = 34916;

	// Field descriptor #71 I
	public static final int GL_CURRENT_QUERY = 34917;

	// Field descriptor #71 I
	public static final int GL_QUERY_RESULT = 34918;

	// Field descriptor #71 I
	public static final int GL_QUERY_RESULT_AVAILABLE = 34919;

	// Field descriptor #194 I
	public static final int GL_SHADING_LANGUAGE_VERSION = 35724;

	// Field descriptor #194 I
	public static final int GL_CURRENT_PROGRAM = 35725;

	// Field descriptor #194 I
	public static final int GL_SHADER_TYPE = 35663;

	// Field descriptor #194 I
	public static final int GL_DELETE_STATUS = 35712;

	// Field descriptor #194 I
	public static final int GL_COMPILE_STATUS = 35713;

	// Field descriptor #194 I
	public static final int GL_LINK_STATUS = 35714;

	// Field descriptor #194 I
	public static final int GL_VALIDATE_STATUS = 35715;

	// Field descriptor #194 I
	public static final int GL_INFO_LOG_LENGTH = 35716;

	// Field descriptor #194 I
	public static final int GL_ATTACHED_SHADERS = 35717;

	// Field descriptor #194 I
	public static final int GL_ACTIVE_UNIFORMS = 35718;

	// Field descriptor #194 I
	public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 35719;

	// Field descriptor #194 I
	public static final int GL_ACTIVE_ATTRIBUTES = 35721;

	// Field descriptor #194 I
	public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 35722;

	// Field descriptor #194 I
	public static final int GL_SHADER_SOURCE_LENGTH = 35720;

	// Field descriptor #194 I
	public static final int GL_SHADER_OBJECT = 35656;

	// Field descriptor #194 I
	public static final int GL_FLOAT_VEC2 = 35664;

	// Field descriptor #194 I
	public static final int GL_FLOAT_VEC3 = 35665;

	// Field descriptor #194 I
	public static final int GL_FLOAT_VEC4 = 35666;

	// Field descriptor #194 I
	public static final int GL_INT_VEC2 = 35667;

	// Field descriptor #194 I
	public static final int GL_INT_VEC3 = 35668;

	// Field descriptor #194 I
	public static final int GL_INT_VEC4 = 35669;

	// Field descriptor #194 I
	public static final int GL_BOOL = 35670;

	// Field descriptor #194 I
	public static final int GL_BOOL_VEC2 = 35671;

	// Field descriptor #194 I
	public static final int GL_BOOL_VEC3 = 35672;

	// Field descriptor #194 I
	public static final int GL_BOOL_VEC4 = 35673;

	// Field descriptor #194 I
	public static final int GL_FLOAT_MAT2 = 35674;

	// Field descriptor #194 I
	public static final int GL_FLOAT_MAT3 = 35675;

	// Field descriptor #194 I
	public static final int GL_FLOAT_MAT4 = 35676;

	// Field descriptor #194 I
	public static final int GL_SAMPLER_1D = 35677;

	// Field descriptor #194 I
	public static final int GL_SAMPLER_2D = 35678;

	// Field descriptor #194 I
	public static final int GL_SAMPLER_3D = 35679;

	// Field descriptor #194 I
	public static final int GL_SAMPLER_CUBE = 35680;

	// Field descriptor #194 I
	public static final int GL_SAMPLER_1D_SHADOW = 35681;

	// Field descriptor #194 I
	public static final int GL_SAMPLER_2D_SHADOW = 35682;

	// Field descriptor #194 I
	public static final int GL_VERTEX_SHADER = 35633;

	// Field descriptor #194 I
	public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 35658;

	// Field descriptor #194 I
	public static final int GL_MAX_VARYING_FLOATS = 35659;

	// Field descriptor #194 I
	public static final int GL_MAX_VERTEX_ATTRIBS = 34921;

	// Field descriptor #194 I
	public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 34930;

	// Field descriptor #194 I
	public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 35660;

	// Field descriptor #194 I
	public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 35661;

	// Field descriptor #194 I
	public static final int GL_MAX_TEXTURE_COORDS = 34929;

	// Field descriptor #194 I
	public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 34370;

	// Field descriptor #194 I
	public static final int GL_VERTEX_PROGRAM_TWO_SIDE = 34371;

	// Field descriptor #194 I
	public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 34338;

	// Field descriptor #194 I
	public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 34339;

	// Field descriptor #194 I
	public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 34340;

	// Field descriptor #194 I
	public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 34341;

	// Field descriptor #194 I
	public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 34922;

	// Field descriptor #194 I
	public static final int GL_CURRENT_VERTEX_ATTRIB = 34342;

	// Field descriptor #194 I
	public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 34373;

	// Field descriptor #194 I
	public static final int GL_FRAGMENT_SHADER = 35632;

	// Field descriptor #194 I
	public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 35657;

	// Field descriptor #194 I
	public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 35723;

	// Field descriptor #194 I
	public static final int GL_MAX_DRAW_BUFFERS = 34852;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER0 = 34853;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER1 = 34854;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER2 = 34855;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER3 = 34856;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER4 = 34857;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER5 = 34858;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER6 = 34859;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER7 = 34860;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER8 = 34861;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER9 = 34862;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER10 = 34863;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER11 = 34864;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER12 = 34865;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER13 = 34866;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER14 = 34867;

	// Field descriptor #194 I
	public static final int GL_DRAW_BUFFER15 = 34868;

	// Field descriptor #194 I
	public static final int GL_POINT_SPRITE = 34913;

	// Field descriptor #194 I
	public static final int GL_COORD_REPLACE = 34914;

	// Field descriptor #194 I
	public static final int GL_POINT_SPRITE_COORD_ORIGIN = 36000;

	// Field descriptor #194 I
	public static final int GL_LOWER_LEFT = 36001;

	// Field descriptor #194 I
	public static final int GL_UPPER_LEFT = 36002;

	// Field descriptor #194 I
	public static final int GL_STENCIL_BACK_FUNC = 34816;

	// Field descriptor #194 I
	public static final int GL_STENCIL_BACK_FAIL = 34817;

	// Field descriptor #194 I
	public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 34818;

	// Field descriptor #194 I
	public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 34819;

	// Field descriptor #194 I
	public static final int GL_STENCIL_BACK_REF = 36003;

	// Field descriptor #194 I
	public static final int GL_STENCIL_BACK_VALUE_MASK = 36004;

	// Field descriptor #194 I
	public static final int GL_STENCIL_BACK_WRITEMASK = 36005;

	// Field descriptor #194 I
	public static final int GL_BLEND_EQUATION_RGB = 32777;

	// Field descriptor #194 I
	public static final int GL_BLEND_EQUATION_ALPHA = 34877;
	
	public static final int GL_CONTEXT_LOST_WEBGL = -144;
	
	public static final int GL_TEXTURE_MAX_ANISOTROPY = -150;





	private static final GLObjectMap<TextureGL> texObjects = new GLObjectMap(256);

	private static boolean enableTexture2D = false;
	private static boolean enableLighting = false;
	private static boolean enableAlphaTest = false;
	private static float alphaThresh = 0.1f;

	private static boolean isCompilingDisplayList = false;
	private static DisplayList compilingDisplayList = null;

	private static boolean enableColorArray = false;
	private static boolean enableNormalArray = false;
	private static boolean enableTex0Array = false;

	private static float colorR = 1.0f;
	private static float colorG = 1.0f;
	private static float colorB = 1.0f;
	private static float colorA = 1.0f;

	private static float normalX = 1.0f;
	private static float normalY = 0.0f;
	private static float normalZ = 0.0f;

	private static float tex0X = 0;
	private static float tex0Y = 0;

	private static boolean enableColorMaterial = false;

	private static float fogColorR = 1.0f;
	private static float fogColorG = 1.0f;
	private static float fogColorB = 1.0f;
	private static float fogColorA = 1.0f;
	private static int fogMode = 1;
	private static boolean fogEnabled = false;
	private static boolean fogPremultiply = false;
	private static float fogStart = 1.0f;
	private static float fogEnd = 1.0f;
	private static float fogDensity = 1.0f;

	private static int bytesUploaded = 0;
	private static int vertexDrawn = 0;
	private static int triangleDrawn = 0;

	private static int matrixMode = GL_MODELVIEW;

	static Matrix4f[] matModelV = new Matrix4f[32];
	static int matModelPointer = 0;

	static Matrix4f[] matProjV = new Matrix4f[6];
	static int matProjPointer = 0;

	static Matrix4f[] matTexV = new Matrix4f[16];
	static int matTexPointer = 0;

	static {
		for (int i = 0; i < matModelV.length; ++i) {
			matModelV[i] = new Matrix4f();
		}
		for (int i = 0; i < matProjV.length; ++i) {
			matProjV[i] = new Matrix4f();
		}
		for (int i = 0; i < matTexV.length; ++i) {
			matTexV[i] = new Matrix4f();
		}
	}

	public static void glClearStack() {
		matModelV[0].load(matModelV[matModelPointer]);
		matModelPointer = 0;
		matProjV[0].load(matProjV[matProjPointer]);
		matProjPointer = 0;
		matTexV[0].load(matTexV[matTexPointer]);
		matTexPointer = 0;
	}

	private static BufferGL quadsToTrianglesBuffer = null;
	private static BufferArrayGL currentArray = null;

	private static class DisplayList {
		private final int id;
		private BufferArrayGL glarray;
		private BufferGL glbuffer;
		private int shaderMode;
		private int listLength;

		private DisplayList(int id) {
			this.id = id;
			this.glarray = null;
			this.glbuffer = null;
			this.shaderMode = -1;
			this.listLength = 0;
		}
	}

	private static final HashMap<Integer, DisplayList> displayLists = new HashMap();
	private static final HashMap<Integer, DisplayList> displayListsInitialized = new HashMap();

	public static final int getDisplayListCount() {
		return displayListsInitialized.size();
	}

	public static final void glEnable(int p1) {
		switch (p1) {
		case GL_DEPTH_TEST:
			_wglEnable(_wGL_DEPTH_TEST);
			break;
		case GL_CULL_FACE:
			_wglEnable(_wGL_CULL_FACE);
			break;
		case GL_BLEND:
			_wglEnable(_wGL_BLEND);
			break;
		case GL_RESCALE_NORMAL:
			break;
		case GL_TEXTURE_2D:
			enableTexture2D = true;
			break;
		case GL_LIGHTING:
			enableLighting = true;
			break;
		case GL_ALPHA_TEST:
			enableAlphaTest = true;
			break;
		case GL_FOG:
			fogEnabled = true;
			break;
		case GL_COLOR_MATERIAL:
			enableColorMaterial = true;
			break;
		case GL_POLYGON_OFFSET_FILL:
			_wglEnable(_wGL_POLYGON_OFFSET_FILL);
		default:
			break;
		}
	}

	public static final void glShadeModel(int p1) {

	}

	public static final void glClearDepth(float p1) {
		_wglClearDepth(-p1);
	}

	public static final void glDepthFunc(int p1) {
		int f = _wGL_GEQUAL;
		switch (p1) {
		case GL_GREATER:
			f = _wGL_LESS;
			break;
		case GL_LEQUAL:
			f = _wGL_GEQUAL;
			break;
		case GL_EQUAL:
			f = _wGL_EQUAL;
		default:
			break;
		}
		_wglDepthFunc(f);
	}

	public static final void glAlphaFunc(int p1, float p2) {
		alphaThresh = p2;
	}

	public static final void glCullFace(int p1) {
		_wglCullFace(p1);
	}

	public static final void glMatrixMode(int p1) {
		matrixMode = p1;
	}

	private static final Matrix4f getMatrix() {
		switch (matrixMode) {
		case GL_MODELVIEW:
		default:
			return matModelV[matModelPointer];
		case GL_PROJECTION:
			return matProjV[matProjPointer];
		case GL_TEXTURE:
			return matTexV[matTexPointer];
		}
	}

	public static final void glLoadIdentity() {
		getMatrix().setIdentity();
	}

	public static final void glViewport(int p1, int p2, int p3, int p4) {
		_wglViewport(p1, p2, p3, p4);
	}

	public static final void glClear(int p1) {
		_wglClear(p1);
	}
	
	public static final void glOrtho(double left, double right, double bottom, double top, double zNear, double zFar) {
		Matrix4f res = getMatrix();
		res.m00 = (float) (2.0f / (right - left));
		res.m01 = 0.0f;
		res.m02 = 0.0f;
		res.m03 = 0.0f;
		res.m10 = 0.0f;
		res.m11 = (float) (2.0f / (top - bottom));
		res.m12 = 0.0f;
		res.m13 = 0.0f;
		res.m20 = 0.0f;
		res.m21 = 0.0f;
		res.m22 = (float) (2.0f / (zFar - zNear));
		res.m23 = 0.0f;
		res.m30 = (float) (-(right + left) / (right - left));
		res.m31 = (float) (-(top + bottom) / (top - bottom));
		res.m32 = (float) ((zFar + zNear) / (zFar - zNear));
		res.m33 = 1.0f;
	}

	public static final void glOrtho(float left, float right, float bottom, float top, float zNear, float zFar) {
		Matrix4f res = getMatrix();
		res.m00 = 2.0f / (right - left);
		res.m01 = 0.0f;
		res.m02 = 0.0f;
		res.m03 = 0.0f;
		res.m10 = 0.0f;
		res.m11 = 2.0f / (top - bottom);
		res.m12 = 0.0f;
		res.m13 = 0.0f;
		res.m20 = 0.0f;
		res.m21 = 0.0f;
		res.m22 = 2.0f / (zFar - zNear);
		res.m23 = 0.0f;
		res.m30 = -(right + left) / (right - left);
		res.m31 = -(top + bottom) / (top - bottom);
		res.m32 = (zFar + zNear) / (zFar - zNear);
		res.m33 = 1.0f;
	}

	private static final Vector3f deevis = new Vector3f();

	public static final void glTranslatef(float p1, float p2, float p3) {
		deevis.set(p1, p2, p3);
		getMatrix().translate(deevis);
		if (isCompilingDisplayList) {
			throw new IllegalArgumentException("matrix is not supported while recording display list use tessellator class instead");
		}
	}

	public static final void glClearColor(float p1, float p2, float p3, float p4) {
		_wglClearColor(p1, p2, p3, p4);
	}

	public static final void glDisable(int p1) {
		switch (p1) {
		case GL_DEPTH_TEST:
			_wglDisable(_wGL_DEPTH_TEST);
			break;
		case GL_CULL_FACE:
			_wglDisable(_wGL_CULL_FACE);
			break;
		case GL_BLEND:
			_wglDisable(_wGL_BLEND);
			break;
		case GL_RESCALE_NORMAL:
			break;
		case GL_TEXTURE_2D:
			enableTexture2D = false;
			break;
		case GL_LIGHTING:
			enableLighting = false;
			break;
		case GL_ALPHA_TEST:
			enableAlphaTest = false;
			break;
		case GL_FOG:
			fogEnabled = false;
			break;
		case GL_COLOR_MATERIAL:
			enableColorMaterial = false;
			break;
		case GL_POLYGON_OFFSET_FILL:
			_wglDisable(_wGL_POLYGON_OFFSET_FILL);
		default:
			break;
		}
	}

	public static final void glColor4f(float p1, float p2, float p3, float p4) {
		colorR = p1;
		colorG = p2;
		colorB = p3;
		colorA = p4;
	}

	public static final int glGetError() {
		int err = _wglGetError();
		if (err == _wGL_CONTEXT_LOST_WEBGL)
			return GL_CONTEXT_LOST_WEBGL;
		return err;
	}

	public static final void glFlush() {
		//...???
	}

	public static final void glLineWidth(float p1) {

	}

	public static final void glTexImage2D(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8,
			ByteBuffer p9) {
		_wglTexImage2D(_wGL_TEXTURE_2D, p2, _wGL_RGBA8, p4, p5, p6, _wGL_RGBA, _wGL_UNSIGNED_BYTE, p9);
	}

	public static final void glLight(int p1, int p2, FloatBuffer p3) {

	}

	public static final void glLightModel(int p1, FloatBuffer p2) {

	}

	private static Vector4f lightPos0vec0 = new Vector4f();
	private static Vector4f lightPos1vec0 = new Vector4f();
	private static Vector4f lightPos0vec = new Vector4f();
	private static Vector4f lightPos1vec = new Vector4f();

	public static final void copyModelToLightMatrix() {
		lightPos0vec0.set(lightPos0vec);
		lightPos1vec0.set(lightPos1vec);
		lightPos0vec.set(0.2f, 1.0f, -0.7f, 0.0f);
		lightPos0vec.normalise();
		lightPos1vec.set(-0.2f, 1.0f, 0.7f, 0.0f);
		lightPos1vec.normalise();
		Matrix4f.transform(matModelV[matModelPointer], lightPos0vec, lightPos0vec).normalise();
		Matrix4f.transform(matModelV[matModelPointer], lightPos1vec, lightPos1vec).normalise();
	}

	public static final void flipLightMatrix() {
		lightPos0vec.x = -lightPos0vec.x;
		lightPos1vec.x = -lightPos1vec.x;
		lightPos0vec.y = -lightPos0vec.y;
		lightPos1vec.y = -lightPos1vec.y;
		lightPos0vec.z = -lightPos0vec.z;
		lightPos1vec.z = -lightPos1vec.z;
	}

	public static final void revertLightMatrix() {
		lightPos0vec.set(lightPos0vec0);
		lightPos1vec.set(lightPos1vec0);
	}

	public static final void glPushMatrix() {
		switch (matrixMode) {
		case GL_MODELVIEW:
		default:
			if (matModelPointer < matModelV.length - 1) {
				++matModelPointer;
				matModelV[matModelPointer].load(matModelV[matModelPointer - 1]);
			} else {
				System.err.println("modelview matrix stack overflow");
			}
			break;
		case GL_PROJECTION:
			if (matProjPointer < matProjV.length - 1) {
				++matProjPointer;
				matProjV[matProjPointer].load(matProjV[matProjPointer - 1]);
			} else {
				System.err.println("projection matrix stack overflow");
			}
			break;
		case GL_TEXTURE:
			if (matTexPointer < matTexV.length - 1) {
				++matTexPointer;
				matTexV[matTexPointer].load(matTexV[matTexPointer - 1]);
			} else {
				System.err.println("texture matrix stack overflow");
			}
			break;
		}
	}

	private static final float toRad = 0.0174532925f;

	public static final void glRotatef(float p1, float p2, float p3, float p4) {
		deevis.set(p2, p3, p4);
		getMatrix().rotate(p1 * toRad, deevis);
		if (isCompilingDisplayList) {
			throw new IllegalArgumentException("matrix is not supported while recording display list use tessellator class instead");
		}
	}

	public static final void glPopMatrix() {
		switch (matrixMode) {
		case GL_MODELVIEW:
		default:
			if (matModelPointer > 0) {
				--matModelPointer;
			} else {
				System.err.println("modelview matrix stack underflow");
			}
			break;
		case GL_PROJECTION:
			if (matProjPointer > 0) {
				--matProjPointer;
			} else {
				System.err.println("projection matrix stack underflow");
			}
			break;
		case GL_TEXTURE:
			if (matTexPointer > 0) {
				--matTexPointer;
			} else {
				System.err.println("texture matrix stack underflow");
			}
			break;
		}
	}

	public static final void glColorMaterial(int p1, int p2) {

	}

	public static final void glGetFloat(int p1, FloatBuffer p2) {
		switch (p1) {
		case GL_MODELVIEW_MATRIX:
		default:
			matModelV[matModelPointer].store(p2);
			break;
		case GL_PROJECTION_MATRIX:
			matProjV[matProjPointer].store(p2);
			break;
		}
	}

	public static final void glGetInteger(int p1, int[] p2) {
		if (p1 == GL_VIEWPORT) {
			_wglGetParameter(_wGL_VIEWPORT, 4, p2);
		}
	}

	public static final void glScalef(float p1, float p2, float p3) {
		deevis.set(p1, p2, p3);
		getMatrix().scale(deevis);
		if (isCompilingDisplayList) {
			throw new IllegalArgumentException("matrix is not supported while recording display list use tessellator class instead");
		}
	}

	public static final void glBlendFunc(int p1, int p2) {
		fogPremultiply = (p1 == GL_ONE && p2 == GL_ONE_MINUS_SRC_ALPHA);
		_wglBlendFunc(p1, p2);
	}
	
	public static final void glBlendFuncSeparate(int p1, int p2, int p3, int p4) {
		fogPremultiply = (p3 == GL_ONE && p4 == GL_ONE_MINUS_SRC_ALPHA);
		_wglBlendFuncSeparate(p1, p2, p3, p4);
	}

	public static final void glDepthMask(boolean p1) {
		_wglDepthMask(p1);
	}

	public static final void glColorMask(boolean p1, boolean p2, boolean p3, boolean p4) {
		_wglColorMask(p1, p2, p3, p4);
	}

	public static final void glBindTexture(int p1, int p2) {
		TextureGL t = texObjects.get(p2);
		_wglBindTexture(_wGL_TEXTURE_2D, t);
	}

	public static final void glCopyTexSubImage2D(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
		_wglCopyTexSubImage2D(_wGL_TEXTURE_2D, p2, p3, p4, p5, p6, p7, p8);
	}

	public static final void glTexParameteri(int p1, int p2, int p3) {
		if(p3 == GL_CLAMP_TO_EDGE || p3 == 10496) {
			p3 = _wGL_CLAMP;
		}
		_wglTexParameteri(p1, p2, p3);
	}

	public static final void glTexParameterf(int p1, int p2, float p3) {
		int pp1 = 0;
		switch (p1) {
		default:
		case GL_TEXTURE_2D:
			pp1 = _wGL_TEXTURE_2D;
			break;
		// case GL_TEXTURE_3D: pp1 = _wGL_TEXTURE_3D; break;
		}
		int pp2 = 0;
		switch (p2) {
		default:
		case GL_TEXTURE_MAX_ANISOTROPY:
			pp2 = _wGL_TEXTURE_MAX_ANISOTROPY;
			break;
		}
		_wglTexParameterf(pp1, pp2, p3);
	}

	public static final void glLogicOp(int p1) {

	}

	public static final void glNormal3f(float p1, float p2, float p3) {
		float len = (float) Math.sqrt(p1 * p1 + p2 * p2 + p3 * p3);
		normalX = p1 / len;
		normalY = p2 / len;
		normalZ = p3 / len;
	}

	public static final int glGenLists(int p1) {
		int base = displayListId + 1;
		for (int i = 0; i < p1; i++) {
			int id = ++displayListId;
			displayLists.put(id, new DisplayList(id));
		}
		return base;
	}

	public static final void _wglBindVertexArray0(BufferArrayGL p1) {
		currentArray = p1;
		_wglBindVertexArray(p1);
	}

	private static int displayListId = 0;

	public static final void glCallList(int p1) {
		if (!isCompilingDisplayList) {
			DisplayList d = displayListsInitialized.get(p1);
			if (d != null && d.listLength > 0) {
				bindTheShader(d.shaderMode | getShaderModeFlag1());
				_wglBindVertexArray0(d.glarray);
				_wglDrawQuadArrays(0, d.listLength);
				shader.unuseProgram();
				vertexDrawn += d.listLength * 6 / 4;
				triangleDrawn += d.listLength / 2;
			}
		}
	}

	public static final void glNewList(int p1, int p2) {
		if (!isCompilingDisplayList) {
			compilingDisplayList = displayLists.get(p1);
			if (compilingDisplayList != null) {
				compilingDisplayList.shaderMode = -1;
				compilingDisplayList.listLength = 0;
				isCompilingDisplayList = true;
			}
		}
	}

	public static final void glEndList() {
		if (isCompilingDisplayList) {
			isCompilingDisplayList = false;
			Object upload = _wGetLowLevelBuffersAppended();
			int l = _wArrayByteLength(upload);
			if (l > 0) {
				if (compilingDisplayList.glbuffer == null) {
					displayListsInitialized.put(compilingDisplayList.id, compilingDisplayList);
					compilingDisplayList.glarray = _wglCreateVertexArray();
					compilingDisplayList.glbuffer = _wglCreateBuffer();
					OpenGLFunctionShader f = OpenGLFunctionShader.instance(compilingDisplayList.shaderMode);
					_wglBindVertexArray0(compilingDisplayList.glarray);
					_wglBindBuffer(_wGL_ARRAY_BUFFER, compilingDisplayList.glbuffer);
					f.setupArrayForProgram();
				}
				_wglBindBuffer(_wGL_ARRAY_BUFFER, compilingDisplayList.glbuffer);
				_wglBufferData(_wGL_ARRAY_BUFFER, upload, _wGL_STATIC_DRAW);
				bytesUploaded += l;
			}
		}
	}

	public static final void glColor3f(float p1, float p2, float p3) {
		colorR = p1;
		colorG = p2;
		colorB = p3;
		colorA = 1.0f;
	}

	public static final void glTexImage2D(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8,
			IntBuffer p9) {
		/*
		 * int pp2 = 0; switch(p3) { default: case GL_RGBA: pp2 = _wGL_RGBA; break; case
		 * GL_BGRA: pp2 = _wGL_BGRA; break; } int pp3 = 0; switch(p7) { default: case
		 * GL_RGBA: pp3 = _wGL_RGBA; break; case GL_BGRA: pp3 = _wGL_BGRA; break; }
		 */
		bytesUploaded += p9.remaining() * 4;
		_wglTexImage2D(_wGL_TEXTURE_2D, p2, _wGL_RGBA8, p4, p5, p6, _wGL_RGBA, _wGL_UNSIGNED_BYTE, p9);
	}

	public static final void glTexImage2D_2(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8,
			IntBuffer p9) {
		bytesUploaded += p9.remaining() * 4;
		_wglTexImage2D(_wGL_TEXTURE_2D, p2, _wGL_RGB8, p4, p5, p6, _wGL_RGB, _wGL_UNSIGNED_BYTE, p9);
	}

	public static final void glTexSubImage2D(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8,
			IntBuffer p9) {
		int pp1 = 0;
		switch (p1) {
		default:
		case GL_TEXTURE_2D:
			pp1 = _wGL_TEXTURE_2D;
			break;
		// case GL_TEXTURE_3D: pp1 = _wGL_TEXTURE_3D; break;
		}
		/*
		 * int pp3 = 0; switch(p7) { default: case GL_RGBA: pp3 = _wGL_RGBA; break; case
		 * GL_BGRA: pp3 = _wGL_BGRA; break; }
		 */
		bytesUploaded += p9.remaining() * 4;
		_wglTexSubImage2D(pp1, p2, p3, p4, p5, p6, _wGL_RGBA, _wGL_UNSIGNED_BYTE, p9);
	}

	public static final void glDeleteTextures(int p1) {
		_wglDeleteTextures(texObjects.free(p1));
	}

	public static final void glPolygonOffset(float p1, float p2) {
		_wglPolygonOffset(p1, p2);
	}

	public static final void glCallLists(IntBuffer p1) {
		while (p1.hasRemaining()) {
			glCallList(p1.get());
		}
	}

	public static final void glEnableVertexAttrib(int p1) {
		switch (p1) {
		case GL_COLOR_ARRAY:
			enableColorArray = true;
			break;
		case GL_NORMAL_ARRAY:
			enableNormalArray = true;
			break;
		case GL_TEXTURE_COORD_ARRAY:
			enableTex0Array = true;
			break;
		default:
			break;
		}
	}

	public static final void glDisableVertexAttrib(int p1) {
		switch (p1) {
		case GL_COLOR_ARRAY:
			enableColorArray = false;
			break;
		case GL_NORMAL_ARRAY:
			enableNormalArray = false;
			break;
		case GL_TEXTURE_COORD_ARRAY:
			enableTex0Array = false;
			break;
		default:
			break;
		}
	}

	private static final int getShaderModeFlag0() {
		int mode = 0;
		mode = (mode | (enableColorArray ? OpenGLFunctionShader.COLOR : 0));
		mode = (mode | (enableNormalArray ? OpenGLFunctionShader.NORMAL : 0));
		mode = (mode | (enableTex0Array ? OpenGLFunctionShader.TEXTURE0 : 0));
		return mode;
	}

	private static final int getShaderModeFlag1() {
		int mode = 0;
		mode = (mode | ((enableColorMaterial && enableLighting) ? OpenGLFunctionShader.LIGHTING : 0));
		mode = (mode | (fogEnabled ? OpenGLFunctionShader.FOG : 0));
		mode = (mode | (enableAlphaTest ? OpenGLFunctionShader.ALPHATEST : 0));
		mode = (mode | (enableTexture2D ? OpenGLFunctionShader.UNIT0 : 0));
		return mode;
	}

	private static final int getShaderModeFlag() {
		int mode = 0;
		mode = (mode | (enableColorArray ? OpenGLFunctionShader.COLOR : 0));
		mode = (mode | (enableNormalArray ? OpenGLFunctionShader.NORMAL : 0));
		mode = (mode | (enableTex0Array ? OpenGLFunctionShader.TEXTURE0 : 0));
		mode = (mode | ((enableColorMaterial && enableLighting) ? OpenGLFunctionShader.LIGHTING : 0));
		mode = (mode | (fogEnabled ? OpenGLFunctionShader.FOG : 0));
		mode = (mode | (enableAlphaTest ? OpenGLFunctionShader.ALPHATEST : 0));
		mode = (mode | (enableTexture2D ? OpenGLFunctionShader.UNIT0 : 0));
		return mode;
	}

	private static OpenGLFunctionShader shader = null;

	private static final void bindTheShader() {
		bindTheShader(getShaderModeFlag());
	}

	private static final void bindTheShader(int mode) {
		OpenGLFunctionShader s = shader = OpenGLFunctionShader.instance(mode);
		s.useProgram();
		if (enableAlphaTest) {
			s.setAlphaTest(alphaThresh);
		}
		s.setColor(colorR, colorG, colorB, colorA);
		if (fogEnabled) {
			s.setFogMode((fogPremultiply ? 2 : 0) + fogMode);
			s.setFogColor(fogColorR, fogColorG, fogColorB, fogColorA);
			s.setFogDensity(fogDensity);
			s.setFogStartEnd(fogStart, fogEnd);
		}
		s.setModelMatrix(matModelV[matModelPointer]);
		s.setProjectionMatrix(matProjV[matProjPointer]);
		s.setTextureMatrix(matTexV[matTexPointer]);
		if (enableColorMaterial && enableLighting) {
			s.setNormal(normalX, normalY, normalZ);
			s.setLightPositions(lightPos0vec, lightPos1vec);
		}
		s.setTex0Coords(tex0X, tex0Y);
	}

	private static Object blankUploadArray = _wCreateLowLevelIntBuffer(525000);

	public static final void glDrawArrays(int p1, int p2, int p3, Object buffer) {
		if (isCompilingDisplayList) {
			if (p1 == GL_QUADS) {
				if (compilingDisplayList.shaderMode == -1) {
					compilingDisplayList.shaderMode = getShaderModeFlag0();
				} else {
					if (compilingDisplayList.shaderMode != getShaderModeFlag0()) {
						System.err.println("vertex format inconsistent in display list");
					}
				}
				compilingDisplayList.listLength += p3;
				_wAppendLowLevelBuffer(buffer);
			} else {
				System.err.println("only GL_QUADS supported in a display list");
			}
		} else {
			bytesUploaded += _wArrayByteLength(buffer);
			vertexDrawn += p3;

			bindTheShader();

			_wglBindVertexArray0(shader.genericArray);
			_wglBindBuffer(_wGL_ARRAY_BUFFER, shader.genericBuffer);
			if (!shader.bufferIsInitialized) {
				shader.bufferIsInitialized = true;
				_wglBufferData(_wGL_ARRAY_BUFFER, blankUploadArray, _wGL_DYNAMIC_DRAW);
			}
			_wglBufferSubData(_wGL_ARRAY_BUFFER, 0, buffer);

			if (p1 == GL_QUADS) {
				_wglDrawQuadArrays(p2, p3);
				triangleDrawn += p3 / 2;
			} else {
				int drawMode = 0;
				switch (p1) {
				default:
				case GL_TRIANGLES:
					drawMode = _wGL_TRIANGLES;
					triangleDrawn += p3 / 3;
					break;
				case GL_TRIANGLE_STRIP:
					drawMode = _wGL_TRIANGLE_STRIP;
					triangleDrawn += p3 - 2;
					break;
				case GL_TRIANGLE_FAN:
					drawMode = _wGL_TRIANGLE_FAN;
					triangleDrawn += p3 - 2;
					break;
				case GL_LINE_STRIP:
					drawMode = _wGL_LINE_STRIP;
					triangleDrawn += p3 - 1;
					break;
				case GL_LINES:
					drawMode = _wGL_LINES;
					triangleDrawn += p3 / 2;
					break;
				}
				_wglDrawArrays(drawMode, p2, p3);
			}

			shader.unuseProgram();

		}
	}

	private static final void _wglDrawQuadArrays(int p2, int p3) {
		if (quadsToTrianglesBuffer == null) {
			IntBuffer upload = IntBuffer.wrap(new int[98400 / 2]);
			for (int i = 0; i < 16384; ++i) {
				int v1 = i * 4;
				int v2 = i * 4 + 1;
				int v3 = i * 4 + 2;
				int v4 = i * 4 + 3;
				upload.put(v1 | (v2 << 16));
				upload.put(v4 | (v2 << 16));
				upload.put(v3 | (v4 << 16));
			}
			upload.flip();
			quadsToTrianglesBuffer = _wglCreateBuffer();
			_wglBindBuffer(_wGL_ELEMENT_ARRAY_BUFFER, quadsToTrianglesBuffer);
			_wglBufferData0(_wGL_ELEMENT_ARRAY_BUFFER, upload, _wGL_STATIC_DRAW);
		}
		if (!currentArray.isQuadBufferBound) {
			currentArray.isQuadBufferBound = true;
			_wglBindBuffer(_wGL_ELEMENT_ARRAY_BUFFER, quadsToTrianglesBuffer);
		}
		_wglDrawElements(_wGL_TRIANGLES, p3 * 6 / 4, _wGL_UNSIGNED_SHORT, p2 * 6 / 4);
	}

	private static BufferArrayGL occlusion_vao = null;
	private static BufferGL occlusion_vbo = null;
	private static ProgramGL occlusion_program = null;
	private static UniformGL occlusion_matrix_m = null;
	private static UniformGL occlusion_matrix_p = null;

	private static final void initializeOcclusionObjects() {
		occlusion_vao = _wglCreateVertexArray();
		occlusion_vbo = _wglCreateBuffer();

		IntBuffer upload = IntBuffer.wrap(new int[108]);
		float[] verts = new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f,
				1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f,
				1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f,
				1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f,
				1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f,
				1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f };
		for (int i = 0; i < verts.length; i++) {
			upload.put(Float.floatToRawIntBits(verts[i]));
		}
		upload.flip();

		_wglBindVertexArray(occlusion_vao);
		_wglBindBuffer(_wGL_ARRAY_BUFFER, occlusion_vbo);
		_wglBufferData0(_wGL_ARRAY_BUFFER, upload, _wGL_STATIC_DRAW);
		_wglEnableVertexAttribArray(0);
		_wglVertexAttribPointer(0, 3, _wGL_FLOAT, false, 12, 0);

		ShaderGL vert = _wglCreateShader(_wGL_VERTEX_SHADER);
		ShaderGL frag = _wglCreateShader(_wGL_FRAGMENT_SHADER);

		String src = "#line 2\n\n" +
        "precision highp int;\n" +
        "precision highp sampler2D;\n" +
        "precision highp float;\n" +
        "\n" +
        "#ifdef CC_VERT\n" +
        "uniform mat4 matrix_m;\n" +
        "uniform mat4 matrix_p;\n" +
        "\n" +
        "in vec3 a_vert;\n" +
        "\n" +
        "void main(){\n" +
        "    gl_Position = (matrix_p * (matrix_m * vec4(a_vert, 1.0)));\n" +
        "}\n" +
        "#endif\n" +
        "\n" +
        "#ifdef CC_FRAG\n" +
        "\n" +
        "out vec4 fragColor;\n" +
        "\n" +
        "void main(){\n" +
        "    fragColor = vec4(1.0);\n" +
        "}\n" +
        "#endif";
		_wglShaderSource(vert, _wgetShaderHeader() + "\n#define CC_VERT\n" + src);
		_wglShaderSource(frag, _wgetShaderHeader() + "\n#define CC_FRAG\n" + src);

		_wglCompileShader(vert);
		if (!_wglGetShaderCompiled(vert))
			System.err.println(("\n" + _wglGetShaderInfoLog(vert)).replace("\n", "\n[/glsl/occl.glsl][VERT] ") + "\n");

		_wglCompileShader(frag);
		if (!_wglGetShaderCompiled(frag))
			System.err.println(("\n" + _wglGetShaderInfoLog(frag)).replace("\n", "\n[/glsl/occl.glsl][FRAG] ") + "\n");

		occlusion_program = _wglCreateProgram();

		_wglAttachShader(occlusion_program, vert);
		_wglAttachShader(occlusion_program, frag);
		_wglLinkProgram(occlusion_program);
		_wglDetachShader(occlusion_program, vert);
		_wglDetachShader(occlusion_program, frag);
		_wglDeleteShader(vert);
		_wglDeleteShader(frag);

		if (!_wglGetProgramLinked(occlusion_program))
			System.err.println(
					("\n\n" + _wglGetProgramInfoLog(occlusion_program)).replace("\n", "\n[/glsl/occl.glsl][LINKER] "));

		_wglUseProgram(occlusion_program);
		occlusion_matrix_m = _wglGetUniformLocation(occlusion_program, "matrix_m");
		occlusion_matrix_p = _wglGetUniformLocation(occlusion_program, "matrix_p");

	}

	private static final GLObjectMap<QueryGL> queryObjs = new GLObjectMap(256);

	public static final int glCreateQuery() {
		return queryObjs.register(_wglCreateQuery());
	}

	public static final void glBeginQuery(int obj) {
		_wglBeginQuery(_wGL_ANY_SAMPLES_PASSED, queryObjs.get(obj));
	}

	public static final void glDeleteQuery(int obj) {
		_wglDeleteQuery(queryObjs.free(obj));
	}

	private static final Matrix4f cachedOcclusionP = (Matrix4f) (new Matrix4f()).setZero();
	private static float[] occlusionModel = new float[16];
	private static float[] occlusionProj = new float[16];

	public static final void glBindOcclusionBB() {
		if (occlusion_vao == null)
			initializeOcclusionObjects();
		_wglUseProgram(occlusion_program);
		_wglBindVertexArray(occlusion_vao);
		if (!cachedOcclusionP.equals(matProjV[matProjPointer])) {
			cachedOcclusionP.load(matProjV[matProjPointer]);
			cachedOcclusionP.store(occlusionProj);
			_wglUniformMat4fv(occlusion_matrix_p, occlusionProj);
		}
	}

	public static final void glEndOcclusionBB() {

	}

	public static final void glDrawOcclusionBB(float posX, float posY, float posZ, float sizeX, float sizeY,
			float sizeZ) {
		glPushMatrix();
		glTranslatef(posX - sizeX * 0.01f, posY - sizeY * 0.01f, posZ - sizeZ * 0.01f);
		glScalef(sizeX * 1.02f, sizeY * 1.02f, sizeZ * 1.02f);
		matModelV[matModelPointer].store(occlusionModel);
		_wglUniformMat4fv(occlusion_matrix_m, occlusionModel);
		_wglDrawArrays(_wGL_TRIANGLES, 0, 36);
		glPopMatrix();

	}

	public static final void glEndQuery() {
		_wglEndQuery(_wGL_ANY_SAMPLES_PASSED);
	}

	public static final boolean glGetQueryResult(int obj) {
		QueryGL q = queryObjs.get(obj);
		return  _wglGetQueryObjecti(q, _wGL_QUERY_RESULT) > 0;
	}

	public static final boolean glGetQueryResultAvailable(int obj) {
		QueryGL q = queryObjs.get(obj);
		return _wglGetQueryObjecti(q, _wGL_QUERY_RESULT_AVAILABLE) > 0;
	}

	public static final int glGenTextures() {
		return texObjects.register(_wglGenTextures());
	}

	public static final void glTexSubImage2D(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8,
			ByteBuffer p9) {
		int pp1 = 0;
		switch (p1) {
		default:
		case GL_TEXTURE_2D:
			pp1 = _wGL_TEXTURE_2D;
			break;
		// case GL_TEXTURE_3D: pp1 = _wGL_TEXTURE_3D; break;
		}
		/*
		 * int pp3 = 0; switch(p7) { default: case GL_RGBA: pp3 = _wGL_RGBA; break; case
		 * GL_BGRA: pp3 = _wGL_BGRA; break; }
		 */
		bytesUploaded += p9.remaining();
		_wglTexSubImage2D(pp1, p2, p3, p4, p5, p6, _wGL_RGBA, _wGL_UNSIGNED_BYTE, p9);
	}

	public static final void glFogi(int p1, int p2) {
		if (p1 == GL_FOG_MODE) {
			switch (p2) {
			default:
			case GL_LINEAR:
				fogMode = 1;
				break;
			case GL_EXP:
				fogMode = 2;
				break;
			}
		}
	}

	public static final void glFogf(int p1, float p2) {
		switch (p1) {
		case GL_FOG_START:
			fogStart = p2;
			break;
		case GL_FOG_END:
			fogEnd = p2;
			break;
		case GL_FOG_DENSITY:
			fogDensity = p2;
			break;
		default:
			break;
		}
	}

	public static final void glFog(int p1, FloatBuffer p2) {
		if (p1 == GL_FOG_COLOR) {
			fogColorR = p2.get();
			fogColorG = p2.get();
			fogColorB = p2.get();
			fogColorA = p2.get();
		}
	}

	public static final void glDeleteLists(int p1, int p2) {
		for (int i = 0; i < p2; i++) {
			DisplayList d = displayListsInitialized.remove(p1 + i);
			if (d != null) {
				_wglDeleteVertexArray(d.glarray);
				_wglDeleteBuffer(d.glbuffer);
			}
			displayLists.remove(p1 + i);
		}
	}

	public static final void glMultiTexCoord2f(int p1, float p2, float p3) {
		tex0X = p2;
		tex0Y = p3;
	}

	private static Matrix4f unprojA = new Matrix4f();
	private static Matrix4f unprojB = new Matrix4f();
	private static Vector4f unprojC = new Vector4f();

	public static final void gluUnProject(float p1, float p2, float p3, FloatBuffer p4, FloatBuffer p5, int[] p6,
			FloatBuffer p7) {
		unprojA.load(p4);
		unprojB.load(p5);
		Matrix4f.mul(unprojA, unprojB, unprojB);
		unprojB.invert();
		unprojC.set(((p1 - (float) p6[0]) / (float) p6[2]) * 2f - 1f, ((p2 - (float) p6[1]) / (float) p6[3]) * 2f - 1f,
				p3, 1.0f);
		Matrix4f.transform(unprojB, unprojC, unprojC);
		p7.put(unprojC.x / unprojC.w);
		p7.put(unprojC.y / unprojC.w);
		p7.put(unprojC.z / unprojC.w);
	}

	public static final void gluPerspective(float fovy, float aspect, float zNear, float zFar) {
		Matrix4f res = getMatrix();
		float cotangent = (float) Math.cos(fovy * toRad * 0.5f) / (float) Math.sin(fovy * toRad * 0.5f);
		res.m00 = cotangent / aspect;
		res.m01 = 0.0f;
		res.m02 = 0.0f;
		res.m03 = 0.0f;
		res.m10 = 0.0f;
		res.m11 = cotangent;
		res.m12 = 0.0f;
		res.m13 = 0.0f;
		res.m20 = 0.0f;
		res.m21 = 0.0f;
		res.m22 = (zFar + zNear) / (zFar - zNear);
		res.m23 = -1.0f;
		res.m30 = 0.0f;
		res.m31 = 0.0f;
		res.m32 = 2.0f * zFar * zNear / (zFar - zNear);
		res.m33 = 0.0f;
	}

	public static final void gluPerspectiveFlat(float fovy, float aspect, float zNear, float zFar) {
		Matrix4f res = getMatrix();
		float cotangent = (float) Math.cos(fovy * toRad * 0.5f) / (float) Math.sin(fovy * toRad * 0.5f);
		res.m00 = cotangent / aspect;
		res.m01 = 0.0f;
		res.m02 = 0.0f;
		res.m03 = 0.0f;
		res.m10 = 0.0f;
		res.m11 = cotangent;
		res.m12 = 0.0f;
		res.m13 = 0.0f;
		res.m20 = 0.0f;
		res.m21 = 0.0f;
		res.m22 = ((zFar + zNear) / (zFar - zNear)) * 0.001f;
		res.m23 = -1.0f;
		res.m30 = 0.0f;
		res.m31 = 0.0f;
		res.m32 = 2.0f * zFar * zNear / (zFar - zNear);
		res.m33 = 0.0f;
	}

	public static final String gluErrorString(int p1) {
		switch (p1) {
		case GL_INVALID_ENUM:
			return "GL_INVALID_ENUM";
		case GL_INVALID_VALUE:
			return "GL_INVALID_VALUE";
		case GL_INVALID_OPERATION:
			return "GL_INVALID_OPERATION";
		case GL_OUT_OF_MEMORY:
			return "GL_OUT_OF_MEMORY";
		case GL_CONTEXT_LOST_WEBGL:
			return "CONTEXT_LOST_WEBGL";
		default:
			return "Unknown Error";
		}
	}

	private static long lastBandwidthReset = 0l;
	private static int lastBandwidth = 0;

	public static final int getBitsPerSecond() {
		if (System.currentTimeMillis() - lastBandwidthReset > 1000) {
			lastBandwidthReset = System.currentTimeMillis();
			lastBandwidth = bytesUploaded * 8;
			bytesUploaded = 0;
		}
		return lastBandwidth;
	}

	public static final int getVertexesPerSecond() {
		int ret = vertexDrawn;
		vertexDrawn = 0;
		return ret;
	}

	public static final int getTrianglesPerSecond() {
		int ret = triangleDrawn;
		triangleDrawn = 0;
		return ret;
	}
}