#include "pch-c.h"
#ifndef _MSC_VER
# include <alloca.h>
#else
# include <malloc.h>
#endif


#include "codegen/il2cpp-codegen-metadata.h"





// 0x00000001 UnityEngine.Vector3[] UnityEngine.Cloth::get_vertices()
extern void Cloth_get_vertices_m730A31FFAA035BE664FF08764A7E2BC61172B722 (void);
// 0x00000002 UnityEngine.ClothSkinningCoefficient[] UnityEngine.Cloth::get_coefficients()
extern void Cloth_get_coefficients_mCDBC30213D6CD0701AB4FB62B84D770B5637CB8C (void);
// 0x00000003 System.Void UnityEngine.Cloth::set_coefficients(UnityEngine.ClothSkinningCoefficient[])
extern void Cloth_set_coefficients_m840AC46566D07BB2BE04DF67A901CA4765B115FA (void);
static Il2CppMethodPointer s_methodPointers[3] = 
{
	Cloth_get_vertices_m730A31FFAA035BE664FF08764A7E2BC61172B722,
	Cloth_get_coefficients_mCDBC30213D6CD0701AB4FB62B84D770B5637CB8C,
	Cloth_set_coefficients_m840AC46566D07BB2BE04DF67A901CA4765B115FA,
};
static const int32_t s_InvokerIndices[3] = 
{
	875,
	875,
	776,
};
extern const CustomAttributesCacheGenerator g_UnityEngine_ClothModule_AttributeGenerators[];
IL2CPP_EXTERN_C const Il2CppCodeGenModule g_UnityEngine_ClothModule_CodeGenModule;
const Il2CppCodeGenModule g_UnityEngine_ClothModule_CodeGenModule = 
{
	"UnityEngine.ClothModule.dll",
	3,
	s_methodPointers,
	0,
	NULL,
	s_InvokerIndices,
	0,
	NULL,
	0,
	NULL,
	0,
	NULL,
	NULL,
	g_UnityEngine_ClothModule_AttributeGenerators,
	NULL, // module initializer,
	NULL,
	NULL,
	NULL,
};
