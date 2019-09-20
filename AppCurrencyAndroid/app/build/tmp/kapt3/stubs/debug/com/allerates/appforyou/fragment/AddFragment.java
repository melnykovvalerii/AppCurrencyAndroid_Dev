package com.allerates.appforyou.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\bc\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 \u008b\u00022\u00020\u00012\u00020\u0002:\u0002\u008b\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u00d2\u0001\u001a\u00030\u00d3\u00012\b\u0010\u00d4\u0001\u001a\u00030\u00d5\u0001J\u001b\u0010\u00d6\u0001\u001a\u00030\u00d3\u00012\u0007\u0010\u00d7\u0001\u001a\u00020\u00062\u0006\u0010]\u001a\u00020LH\u0002J\n\u0010\u00d8\u0001\u001a\u00030\u00d3\u0001H\u0002J\u0014\u0010\u00d9\u0001\u001a\u00030\u00d3\u00012\b\u0010g\u001a\u0004\u0018\u00010hH\u0002J.\u0010\u00da\u0001\u001a\u00030\u00d3\u00012\u0007\u0010\u00db\u0001\u001a\u00020\u000e2\u0007\u0010\u00dc\u0001\u001a\u00020L2\u0007\u0010\u00dd\u0001\u001a\u00020L2\u0007\u0010\u00de\u0001\u001a\u00020\u0006H\u0002J\u0014\u0010\u00df\u0001\u001a\u00030\u00d3\u00012\b\u0010\u00d4\u0001\u001a\u00030\u00d5\u0001H\u0002J(\u0010\u00e0\u0001\u001a\u00030\u00d3\u00012\u0007\u0010\u00e1\u0001\u001a\u00020L2\u0007\u0010\u00e2\u0001\u001a\u00020L2\n\u0010\u00e3\u0001\u001a\u0005\u0018\u00010\u00e4\u0001H\u0016J\u0014\u0010\u00e5\u0001\u001a\u00030\u00d3\u00012\b\u0010\u00d4\u0001\u001a\u00030\u00d5\u0001H\u0007J\u0014\u0010\u00e6\u0001\u001a\u00030\u00d3\u00012\b\u0010\u00d4\u0001\u001a\u00030\u00d5\u0001H\u0007J\u0014\u0010\u00e7\u0001\u001a\u00030\u00d3\u00012\b\u0010\u00d4\u0001\u001a\u00030\u00d5\u0001H\u0007J\u0014\u0010\u00e8\u0001\u001a\u00030\u00d3\u00012\b\u0010\u00d4\u0001\u001a\u00030\u00d5\u0001H\u0007J\u0014\u0010\u00e9\u0001\u001a\u00030\u00d3\u00012\b\u0010\u00ea\u0001\u001a\u00030\u00d5\u0001H\u0007J\u0014\u0010\u00eb\u0001\u001a\u00030\u00d3\u00012\b\u0010\u00ea\u0001\u001a\u00030\u00d5\u0001H\u0007J\u0014\u0010\u00ec\u0001\u001a\u00030\u00d3\u00012\b\u0010\u00ea\u0001\u001a\u00030\u00d5\u0001H\u0007J\u0014\u0010\u00ed\u0001\u001a\u00030\u00d3\u00012\b\u0010\u00ee\u0001\u001a\u00030\u00d5\u0001H\u0016J.\u0010\u00ef\u0001\u001a\u0005\u0018\u00010\u00d5\u00012\b\u0010\u00f0\u0001\u001a\u00030\u00f1\u00012\n\u0010\u00f2\u0001\u001a\u0005\u0018\u00010\u00f3\u00012\n\u0010\u00f4\u0001\u001a\u0005\u0018\u00010\u00f5\u0001H\u0016J\n\u0010\u00f6\u0001\u001a\u00030\u00d3\u0001H\u0016J\u0013\u0010\u00f7\u0001\u001a\u00030\u00d3\u00012\u0007\u0010\u00db\u0001\u001a\u00020\u000eH\u0007J\u000b\u0010\u00f8\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010\u00f9\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u00fa\u0001\u001a\u00020\u0006H\u0002J\u0016\u0010\u00fb\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u00fc\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010\u00fd\u0001\u001a\u00030\u00d3\u00012\b\u0010\u00d4\u0001\u001a\u00030\u00d5\u0001H\u0002J\u001e\u0010\u00fe\u0001\u001a\u00030\u00d3\u00012\t\u0010\u00ff\u0001\u001a\u0004\u0018\u00010\u000e2\u0007\u0010\u0080\u0002\u001a\u00020\u0006H\u0002J\u001a\u0010\u0081\u0002\u001a\u00030\u00d3\u00012\u0006\u0010K\u001a\u00020L2\u0006\u0010Y\u001a\u00020LH\u0002J\u0015\u0010\u0082\u0002\u001a\u00030\u00d3\u00012\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\u0015\u0010\u0084\u0002\u001a\u00030\u00d3\u00012\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\u0013\u0010\u0085\u0002\u001a\u00030\u00d3\u00012\u0007\u0010\u0086\u0002\u001a\u00020LH\u0002J\u0011\u0010\u0087\u0002\u001a\u00030\u00d3\u00012\u0007\u0010\u0088\u0002\u001a\u00020hJ\r\u0010\u0089\u0002\u001a\u00020Q*\u00020\u0006H\u0002J\u0016\u0010\u0089\u0002\u001a\u00020Q*\u00020\u00062\u0007\u0010\u008a\u0002\u001a\u00020LH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R \u0010%\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R \u0010*\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\'\"\u0004\b,\u0010)R \u0010-\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\'\"\u0004\b/\u0010)R \u00100\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\'\"\u0004\b2\u0010)R \u00103\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\'\"\u0004\b5\u0010)R \u00106\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010!R \u00109\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001f\"\u0004\b;\u0010!R \u0010<\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001f\"\u0004\b>\u0010!R \u0010?\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\'\"\u0004\bA\u0010)R \u0010B\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0010\"\u0004\bD\u0010\u0012R \u0010E\u001a\u0004\u0018\u00010F8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020LX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020LX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020LX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020LX\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u00020Q8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010RR\u000e\u0010S\u001a\u00020QX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020UX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020UX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020LX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010Z\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u001f\"\u0004\b\\\u0010!R\u000e\u0010]\u001a\u00020LX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010^\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\'\"\u0004\b`\u0010)R\u001e\u0010a\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u001f\"\u0004\bc\u0010!R\u001e\u0010d\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u001f\"\u0004\bf\u0010!R\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010i\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\'\"\u0004\bk\u0010)R\u0010\u0010l\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060oX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010pR\u0010\u0010q\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010y\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010{\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010}\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R!\u0010~\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\'\"\u0005\b\u0080\u0001\u0010)R#\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0010\"\u0005\b\u0083\u0001\u0010\u0012R#\u0010\u0084\u0001\u001a\u0004\u0018\u00010F8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010H\"\u0005\b\u0086\u0001\u0010JR#\u0010\u0087\u0001\u001a\u0004\u0018\u00010F8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010H\"\u0005\b\u0089\u0001\u0010JR#\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\'\"\u0005\b\u008c\u0001\u0010)R#\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\'\"\u0005\b\u008f\u0001\u0010)R#\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\'\"\u0005\b\u0092\u0001\u0010)R#\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\'\"\u0005\b\u0095\u0001\u0010)R#\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\'\"\u0005\b\u0098\u0001\u0010)R#\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010\'\"\u0005\b\u009b\u0001\u0010)R#\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010\'\"\u0005\b\u009e\u0001\u0010)R#\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a0\u0001\u0010\'\"\u0005\b\u00a1\u0001\u0010)R#\u0010\u00a2\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a3\u0001\u0010\'\"\u0005\b\u00a4\u0001\u0010)R#\u0010\u00a5\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a6\u0001\u0010\'\"\u0005\b\u00a7\u0001\u0010)R#\u0010\u00a8\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a9\u0001\u0010\'\"\u0005\b\u00aa\u0001\u0010)R#\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ac\u0001\u0010\'\"\u0005\b\u00ad\u0001\u0010)R#\u0010\u00ae\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00af\u0001\u0010\'\"\u0005\b\u00b0\u0001\u0010)R#\u0010\u00b1\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b2\u0001\u0010\'\"\u0005\b\u00b3\u0001\u0010)R#\u0010\u00b4\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b5\u0001\u0010\'\"\u0005\b\u00b6\u0001\u0010)R#\u0010\u00b7\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b8\u0001\u0010\'\"\u0005\b\u00b9\u0001\u0010)R#\u0010\u00ba\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00bb\u0001\u0010\'\"\u0005\b\u00bc\u0001\u0010)R#\u0010\u00bd\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00be\u0001\u0010\'\"\u0005\b\u00bf\u0001\u0010)R#\u0010\u00c0\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c1\u0001\u0010\'\"\u0005\b\u00c2\u0001\u0010)R#\u0010\u00c3\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c4\u0001\u0010\'\"\u0005\b\u00c5\u0001\u0010)R#\u0010\u00c6\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c7\u0001\u0010\'\"\u0005\b\u00c8\u0001\u0010)R#\u0010\u00c9\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ca\u0001\u0010\'\"\u0005\b\u00cb\u0001\u0010)R#\u0010\u00cc\u0001\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00cd\u0001\u0010\'\"\u0005\b\u00ce\u0001\u0010)R!\u0010\u00cf\u0001\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d0\u0001\u0010\u001f\"\u0005\b\u00d1\u0001\u0010!\u00a8\u0006\u008c\u0002"}, d2 = {"Lcom/allerates/appforyou/fragment/AddFragment;", "Landroid/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "availableCrypts", "", "", "binder", "Lbutterknife/Unbinder;", "getBinder", "()Lbutterknife/Unbinder;", "setBinder", "(Lbutterknife/Unbinder;)V", "btnFromTime", "Landroid/widget/Button;", "getBtnFromTime$app_debug", "()Landroid/widget/Button;", "setBtnFromTime$app_debug", "(Landroid/widget/Button;)V", "btnPayMethBtn", "getBtnPayMethBtn$app_debug", "setBtnPayMethBtn$app_debug", "btnSelected", "btnToTime", "getBtnToTime$app_debug", "setBtnToTime$app_debug", "calendar", "Ljava/util/Calendar;", "commentEditText", "Landroid/widget/EditText;", "getCommentEditText", "()Landroid/widget/EditText;", "setCommentEditText", "(Landroid/widget/EditText;)V", "createBtn", "getCreateBtn$app_debug", "setCreateBtn$app_debug", "cryptoCurrencyNames", "getCryptoCurrencyNames$app_debug", "()Ljava/lang/String;", "setCryptoCurrencyNames$app_debug", "(Ljava/lang/String;)V", "currencyIsNot", "getCurrencyIsNot$app_debug", "setCurrencyIsNot$app_debug", "defString", "getDefString$app_debug", "setDefString$app_debug", "defStringOneSpace", "getDefStringOneSpace$app_debug", "setDefStringOneSpace$app_debug", "downArrow", "getDownArrow$app_debug", "setDownArrow$app_debug", "edAbout", "getEdAbout$app_debug", "setEdAbout$app_debug", "edAddress", "getEdAddress$app_debug", "setEdAddress$app_debug", "edNumber", "getEdNumber$app_debug", "setEdNumber$app_debug", "format", "getFormat$app_debug", "setFormat$app_debug", "fromDayWeek", "getFromDayWeek$app_debug", "setFromDayWeek$app_debug", "fromTime", "Landroid/widget/TextView;", "getFromTime$app_debug", "()Landroid/widget/TextView;", "setFromTime$app_debug", "(Landroid/widget/TextView;)V", "hour", "", "intCard", "intCash", "intMailCash", "isExternalStorageReadable", "", "()Z", "isWeekButton", "mLatitudeDoub", "", "mLongitudeDoub", "menu", "Landroid/view/Menu;", "min", "minSumEditText", "getMinSumEditText", "setMinSumEditText", "numbPaymentMethod", "paymentMethodNumber", "getPaymentMethodNumber$app_debug", "setPaymentMethodNumber$app_debug", "phoneEditText", "getPhoneEditText", "setPhoneEditText", "placeEditText", "getPlaceEditText", "setPlaceEditText", "point", "Lcom/allerates/appforyou/model/Point;", "requiredField", "getRequiredField$app_debug", "setRequiredField$app_debug", "stAbout", "stAddress", "stArr", "", "[Ljava/lang/String;", "stCard", "stCash", "stCurrency", "stFromDaysOfTheWeek", "stFromTime", "stMailCash", "stMinSum", "stPayMeth", "stPayMethBtn", "stPhone", "stSite", "stToDaysOfTheWeek", "stToTime", "theNumber", "getTheNumber$app_debug", "setTheNumber$app_debug", "toDayWeek", "getToDayWeek$app_debug", "setToDayWeek$app_debug", "toTime", "getToTime$app_debug", "setToTime$app_debug", "tvToTime", "getTvToTime$app_debug", "setTvToTime$app_debug", "txtAboutCurrencyExchange", "getTxtAboutCurrencyExchange$app_debug", "setTxtAboutCurrencyExchange$app_debug", "txtAdditionalInformation", "getTxtAdditionalInformation$app_debug", "setTxtAdditionalInformation$app_debug", "txtAdress", "getTxtAdress$app_debug", "setTxtAdress$app_debug", "txtAm", "getTxtAm$app_debug", "setTxtAm$app_debug", "txtCardCheck", "getTxtCardCheck$app_debug", "setTxtCardCheck$app_debug", "txtCash", "getTxtCash$app_debug", "setTxtCash$app_debug", "txtColon", "getTxtColon$app_debug", "setTxtColon$app_debug", "txtComma", "getTxtComma$app_debug", "setTxtComma$app_debug", "txtDot", "getTxtDot$app_debug", "setTxtDot$app_debug", "txtEmpty", "getTxtEmpty$app_debug", "setTxtEmpty$app_debug", "txtField", "getTxtField$app_debug", "setTxtField$app_debug", "txtLatitude", "getTxtLatitude$app_debug", "setTxtLatitude$app_debug", "txtLeftSquareBrackets", "getTxtLeftSquareBrackets$app_debug", "setTxtLeftSquareBrackets$app_debug", "txtLongitude", "getTxtLongitude$app_debug", "setTxtLongitude$app_debug", "txtMailCash", "getTxtMailCash$app_debug", "setTxtMailCash$app_debug", "txtMapFile", "getTxtMapFile$app_debug", "setTxtMapFile$app_debug", "txtPm", "getTxtPm$app_debug", "setTxtPm$app_debug", "txtRightSquareBrackets", "getTxtRightSquareBrackets$app_debug", "setTxtRightSquareBrackets$app_debug", "txtSelectImage", "getTxtSelectImage$app_debug", "setTxtSelectImage$app_debug", "txtSite", "getTxtSite$app_debug", "setTxtSite$app_debug", "txtTheMinimumAmount", "getTxtTheMinimumAmount$app_debug", "setTxtTheMinimumAmount$app_debug", "txtThePhoneNumber", "getTxtThePhoneNumber$app_debug", "setTxtThePhoneNumber$app_debug", "txtYouSelected", "getTxtYouSelected$app_debug", "setTxtYouSelected$app_debug", "urlEditText", "getUrlEditText", "setUrlEditText", "anim", "", "view", "Landroid/view/View;", "checkChosenPaymentMethod", "btnString", "checkForValidation", "createPoint", "editAvailableList", "button", "idContain", "idNotContain", "name", "init", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBtnFromDayWeek", "onBtnFromTime", "onBtnPayMeth", "onBtnTvToTime", "onButClick", "v", "onButDayWeek", "onButtonClick", "onClick", "p", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onSaveClick", "readExternalStoragePrivateFile", "removeFirstChar", "s", "removeSecondChar", "str", "setFocus", "setSource", "btnConvert", "selString", "showTime", "showToast", "txtFild", "showToastIncInt", "startDialog", "numberToCheck", "writeExternalStoragePrivateFile", "cit", "isInt", "radix", "Companion", "app_debug"})
public final class AddFragment extends android.app.Fragment implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = 2131296719)
    public android.widget.EditText urlEditText;
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = 2131296419)
    public android.widget.EditText phoneEditText;
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = 2131296414)
    public android.widget.EditText placeEditText;
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = 2131296417)
    public android.widget.EditText minSumEditText;
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = 2131296413)
    public android.widget.EditText commentEditText;
    private final java.util.List<java.lang.String> availableCrypts = null;
    @org.jetbrains.annotations.NotNull()
    public butterknife.Unbinder binder;
    private int hour;
    private int min;
    private java.lang.String stCurrency;
    private final com.allerates.appforyou.model.Point point = null;
    private double mLongitudeDoub;
    private double mLatitudeDoub;
    private boolean isWeekButton;
    private java.lang.String[] stArr;
    private java.lang.String stSite;
    private java.lang.String stPhone;
    private java.lang.String stAddress;
    private java.lang.String stAbout;
    private java.lang.String stMinSum;
    private java.lang.String stToDaysOfTheWeek;
    private java.lang.String stFromDaysOfTheWeek;
    private java.lang.String stFromTime;
    private java.lang.String stToTime;
    private final java.lang.String stPayMethBtn = null;
    private java.lang.String stPayMeth;
    private java.lang.String stCash;
    private java.lang.String stCard;
    private java.lang.String stMailCash;
    private java.util.Calendar calendar;
    private final android.view.Menu menu = null;
    private android.widget.Button btnSelected;
    private final int intCash = 0;
    private final int intCard = 0;
    private final int intMailCash = 0;
    private int numbPaymentMethod;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755111)
    private java.lang.String defString;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755247)
    private java.lang.String currencyIsNot;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755287)
    private java.lang.String txtSelectImage;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755240)
    private java.lang.String txtComma;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755275)
    private java.lang.String txtLeftSquareBrackets;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755285)
    private java.lang.String txtRightSquareBrackets;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755274)
    private java.lang.String txtLatitude;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755278)
    private java.lang.String txtLongitude;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755113)
    private java.lang.String defStringOneSpace;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755280)
    private java.lang.String txtMapFile;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755255)
    private java.lang.String txtDot;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755086)
    private java.lang.String txtColon;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755233)
    private java.lang.String txtAm;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755284)
    private java.lang.String txtPm;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755258)
    private java.lang.String txtEmpty;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755192)
    private java.lang.String requiredField;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755227)
    private java.lang.String theNumber;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755263)
    private java.lang.String txtField;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755298)
    private java.lang.String txtTheMinimumAmount;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755208)
    private java.lang.String txtAdditionalInformation;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755230)
    private java.lang.String txtAboutCurrencyExchange;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755232)
    private java.lang.String txtAdress;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755300)
    private java.lang.String txtThePhoneNumber;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755111)
    private java.lang.String format;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755294)
    private java.lang.String txtSite;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindView(value = 2131296322)
    private android.widget.Button fromDayWeek;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindView(value = 2131296703)
    private android.widget.Button toDayWeek;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindView(value = 2131296384)
    private android.widget.Button createBtn;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindView(value = 2131296317)
    private android.widget.Button btnPayMethBtn;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindView(value = 2131296328)
    private android.widget.Button btnToTime;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindView(value = 2131296323)
    private android.widget.Button btnFromTime;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindView(value = 2131296737)
    private android.widget.TextView toTime;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindView(value = 2131296721)
    private android.widget.TextView fromTime;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindView(value = 2131296734)
    private android.widget.TextView tvToTime;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindView(value = 2131296419)
    private android.widget.EditText edNumber;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindView(value = 2131296414)
    private android.widget.EditText edAddress;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindView(value = 2131296413)
    private android.widget.EditText edAbout;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755244)
    private java.lang.String cryptoCurrencyNames;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755186)
    private java.lang.String paymentMethodNumber;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755306)
    private java.lang.String txtYouSelected;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755256)
    private java.lang.String downArrow;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755279)
    private java.lang.String txtMailCash;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755238)
    private java.lang.String txtCardCheck;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755239)
    private java.lang.String txtCash;
    private static final int GALLERY_PICK = 1;
    private static final int DIALOG_PICK = 2;
    public static final com.allerates.appforyou.fragment.AddFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View p) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getUrlEditText() {
        return null;
    }
    
    public final void setUrlEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getPhoneEditText() {
        return null;
    }
    
    public final void setPhoneEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getPlaceEditText() {
        return null;
    }
    
    public final void setPlaceEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getMinSumEditText() {
        return null;
    }
    
    public final void setMinSumEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getCommentEditText() {
        return null;
    }
    
    public final void setCommentEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final butterknife.Unbinder getBinder() {
        return null;
    }
    
    public final void setBinder(@org.jetbrains.annotations.NotNull()
    butterknife.Unbinder p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDefString$app_debug() {
        return null;
    }
    
    public final void setDefString$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrencyIsNot$app_debug() {
        return null;
    }
    
    public final void setCurrencyIsNot$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtSelectImage$app_debug() {
        return null;
    }
    
    public final void setTxtSelectImage$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtComma$app_debug() {
        return null;
    }
    
    public final void setTxtComma$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtLeftSquareBrackets$app_debug() {
        return null;
    }
    
    public final void setTxtLeftSquareBrackets$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtRightSquareBrackets$app_debug() {
        return null;
    }
    
    public final void setTxtRightSquareBrackets$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtLatitude$app_debug() {
        return null;
    }
    
    public final void setTxtLatitude$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtLongitude$app_debug() {
        return null;
    }
    
    public final void setTxtLongitude$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDefStringOneSpace$app_debug() {
        return null;
    }
    
    public final void setDefStringOneSpace$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtMapFile$app_debug() {
        return null;
    }
    
    public final void setTxtMapFile$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtDot$app_debug() {
        return null;
    }
    
    public final void setTxtDot$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtColon$app_debug() {
        return null;
    }
    
    public final void setTxtColon$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtAm$app_debug() {
        return null;
    }
    
    public final void setTxtAm$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtPm$app_debug() {
        return null;
    }
    
    public final void setTxtPm$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtEmpty$app_debug() {
        return null;
    }
    
    public final void setTxtEmpty$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRequiredField$app_debug() {
        return null;
    }
    
    public final void setRequiredField$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTheNumber$app_debug() {
        return null;
    }
    
    public final void setTheNumber$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtField$app_debug() {
        return null;
    }
    
    public final void setTxtField$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtTheMinimumAmount$app_debug() {
        return null;
    }
    
    public final void setTxtTheMinimumAmount$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtAdditionalInformation$app_debug() {
        return null;
    }
    
    public final void setTxtAdditionalInformation$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtAboutCurrencyExchange$app_debug() {
        return null;
    }
    
    public final void setTxtAboutCurrencyExchange$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtAdress$app_debug() {
        return null;
    }
    
    public final void setTxtAdress$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtThePhoneNumber$app_debug() {
        return null;
    }
    
    public final void setTxtThePhoneNumber$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFormat$app_debug() {
        return null;
    }
    
    public final void setFormat$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtSite$app_debug() {
        return null;
    }
    
    public final void setTxtSite$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getFromDayWeek$app_debug() {
        return null;
    }
    
    public final void setFromDayWeek$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getToDayWeek$app_debug() {
        return null;
    }
    
    public final void setToDayWeek$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getCreateBtn$app_debug() {
        return null;
    }
    
    public final void setCreateBtn$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getBtnPayMethBtn$app_debug() {
        return null;
    }
    
    public final void setBtnPayMethBtn$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getBtnToTime$app_debug() {
        return null;
    }
    
    public final void setBtnToTime$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getBtnFromTime$app_debug() {
        return null;
    }
    
    public final void setBtnFromTime$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getToTime$app_debug() {
        return null;
    }
    
    public final void setToTime$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getFromTime$app_debug() {
        return null;
    }
    
    public final void setFromTime$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getTvToTime$app_debug() {
        return null;
    }
    
    public final void setTvToTime$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.EditText getEdNumber$app_debug() {
        return null;
    }
    
    public final void setEdNumber$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.EditText getEdAddress$app_debug() {
        return null;
    }
    
    public final void setEdAddress$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.EditText getEdAbout$app_debug() {
        return null;
    }
    
    public final void setEdAbout$app_debug(@org.jetbrains.annotations.Nullable()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCryptoCurrencyNames$app_debug() {
        return null;
    }
    
    public final void setCryptoCurrencyNames$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPaymentMethodNumber$app_debug() {
        return null;
    }
    
    public final void setPaymentMethodNumber$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtYouSelected$app_debug() {
        return null;
    }
    
    public final void setTxtYouSelected$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDownArrow$app_debug() {
        return null;
    }
    
    public final void setDownArrow$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtMailCash$app_debug() {
        return null;
    }
    
    public final void setTxtMailCash$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtCardCheck$app_debug() {
        return null;
    }
    
    public final void setTxtCardCheck$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtCash$app_debug() {
        return null;
    }
    
    public final void setTxtCash$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    private final boolean isExternalStorageReadable() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void editAvailableList(android.widget.Button button, int idContain, int idNotContain, java.lang.String name) {
    }
    
    @butterknife.OnClick(value = {2131296318})
    public final void onSaveClick(@org.jetbrains.annotations.NotNull()
    android.widget.Button button) {
    }
    
    private final void checkChosenPaymentMethod(java.lang.String btnString, int numbPaymentMethod) {
    }
    
    @butterknife.OnClick(value = {2131296384})
    public final void onButtonClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @butterknife.OnClick(value = {2131296703})
    public final void onButDayWeek(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @butterknife.OnClick(value = {2131296322})
    public final void onBtnFromDayWeek(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @butterknife.OnClick(value = {2131296328})
    public final void onBtnTvToTime(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @butterknife.OnClick(value = {2131296323})
    public final void onBtnFromTime(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @butterknife.OnClick(value = {2131296317})
    public final void onBtnPayMeth(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void checkForValidation() {
    }
    
    private final void createPoint(com.allerates.appforyou.model.Point point) {
    }
    
    private final java.lang.String removeSecondChar(java.lang.String str) {
        return null;
    }
    
    private final java.lang.String removeFirstChar(java.lang.String s) {
        return null;
    }
    
    private final void setFocus(android.view.View view) {
    }
    
    public final void anim(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final java.lang.String readExternalStoragePrivateFile() {
        return null;
    }
    
    public final void writeExternalStoragePrivateFile(@org.jetbrains.annotations.NotNull()
    com.allerates.appforyou.model.Point cit) {
    }
    
    private final void showToast(java.lang.String txtFild) {
    }
    
    private final void showToastIncInt(java.lang.String txtFild) {
    }
    
    private final void init(android.view.View view) {
    }
    
    private final void showTime(int hour, int min) {
    }
    
    private final void startDialog(int numberToCheck) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void setSource(android.widget.Button btnConvert, java.lang.String selString) {
    }
    
    @butterknife.OnClick(value = {2131296290})
    public final void onButClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    private final boolean isInt(@org.jetbrains.annotations.NotNull()
    java.lang.String $receiver) {
        return false;
    }
    
    private final boolean isInt(@org.jetbrains.annotations.NotNull()
    java.lang.String $receiver, int radix) {
        return false;
    }
    
    public AddFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/allerates/appforyou/fragment/AddFragment$Companion;", "", "()V", "DIALOG_PICK", "", "GALLERY_PICK", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}