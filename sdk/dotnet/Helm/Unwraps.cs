// Copyright 2016-2021, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System.Collections.Generic;
using System.Collections.Immutable;
using Pulumi.Kubernetes.Yaml;

namespace Pulumi.Kubernetes.Helm
{
    internal class BaseChartArgsUnwrap
    {
        public ImmutableArray<string> ApiVersions { get; set; }
        public bool? IncludeTestHookResources { get; set; }
        public bool? SkipCRDRendering { get; set; }
        public bool? SkipAwait { get; set; }
        public string? Namespace { get; set; }
        public string? KubeVersion { get; set; }
        public ImmutableDictionary<string, object> Values { get; set; } = null!;
        public List<TransformationAction> Transformations { get; set; } = null!;
        public string? ResourcePrefix { get; set; }
    }

    internal class ChartArgsUnwrap : BaseChartArgsUnwrap
    {
        public string? Repo { get; set; }
        public string Chart { get; set; } = null!;
        public string? Version { get; set; }
        public ChartFetchArgsUnwrap? FetchOptions { get; set; }
    }

    internal class LocalChartArgsUnwrap : BaseChartArgsUnwrap
    {
        public string Path { get; set; } = null!;
    }

    internal class ChartFetchArgsUnwrap
    {
        public string? Version { get; set; }
        public string? CAFile { get; set; }
        public string? CertFile { get; set; }
        public string? KeyFile { get; set; }
        public string? Destination { get; set; }
        public string? Keyring { get; set; }
        public string? Password { get; set; }
        public string? Repo { get; set; }
        public string? UntarDir { get; set; }
        public string? Username { get; set; }
        public string? Home { get; set; }
        public bool? Devel { get; set; }
        public bool? Prov { get; set; }
        public bool? Untar { get; set; }
        public bool? Verify { get; set; }
    }

    internal static class Extensions
    {
        public static Output<Union<ChartArgsUnwrap, LocalChartArgsUnwrap>> Unwrap(this Union<ChartArgs, LocalChartArgs> options)
        {
            return options.Match(
                v => Output.Tuple(v.ApiVersions, v.Values, v.Chart, v.FetchOptions.Unwrap(), new InputList<string?> { v.Namespace.ToNullable(), v.Repo.ToNullable(), v.Version.ToNullable(), v.KubeVersion.ToNullable() }, new InputList<bool?> { v.IncludeTestHookResources.ToNullable(), v.SkipCRDRendering.ToNullable(), v.SkipAwait.ToNullable() }).Apply(vs =>
                    Union<ChartArgsUnwrap, LocalChartArgsUnwrap>.FromT0(
                        new ChartArgsUnwrap
                        {
                            ApiVersions = vs.Item1,
                            Values = vs.Item2,
                            Chart = vs.Item3,
                            FetchOptions = vs.Item4,
                            Namespace = vs.Item5[0],
                            Repo = vs.Item5[1],
                            Version = vs.Item5[2],
                            KubeVersion = vs.Item5[3],
                            IncludeTestHookResources = vs.Item6[0],
                            SkipCRDRendering = vs.Item6[1],
                            SkipAwait = vs.Item6[2],
                            Transformations = v.Transformations,
                            ResourcePrefix = v.ResourcePrefix,
                        })),
                v => Output.Tuple(v.ApiVersions, v.IncludeTestHookResources.ToNullable(), v.SkipCRDRendering.ToNullable(), v.SkipAwait.ToNullable(), v.Namespace.ToNullable(), v.Values, v.KubeVersion.ToNullable()).Apply(vs =>
                    Union<ChartArgsUnwrap, LocalChartArgsUnwrap>.FromT1(
                        new LocalChartArgsUnwrap
                        {
                            ApiVersions = vs.Item1,
                            IncludeTestHookResources = vs.Item2,
                            SkipCRDRendering = vs.Item3,
                            SkipAwait = vs.Item4,
                            Namespace = vs.Item5,
                            Values = vs.Item6,
                            KubeVersion = vs.Item7,
                            Transformations = v.Transformations,
                            ResourcePrefix = v.ResourcePrefix,
                            Path = v.Path
                        })));
        }

        private static Input<ChartFetchArgsUnwrap?> Unwrap(this Input<ChartFetchArgs>? options)
        {
            if (options == null)
            {
                return Output.Create((ChartFetchArgsUnwrap?)null);
            }

            var strings = options.Apply(o => Output.All(
                o.Version.ToNullable(), o.CAFile.ToNullable(), o.CertFile.ToNullable(), o.KeyFile.ToNullable(),
                o.Destination.ToNullable(), o.Keyring.ToNullable(),
                o.Password.ToNullable(), o.Repo.ToNullable(), o.UntarDir.ToNullable(), o.Username.ToNullable(),
                o.Home.ToNullable()));
            var bools = options.Apply(o => Output.All(
                o.Devel.ToNullable(), o.Prov.ToNullable(), o.Untar.ToNullable(), o.Verify.ToNullable()));
            return Output.Tuple(strings, bools).Apply(vs =>
                new ChartFetchArgsUnwrap
                {
                    Version = vs.Item1[0],
                    CAFile = vs.Item1[1],
                    CertFile = vs.Item1[2],
                    KeyFile = vs.Item1[3],
                    Destination = vs.Item1[4],
                    Keyring = vs.Item1[5],
                    Password = vs.Item1[6],
                    Repo = vs.Item1[7],
                    UntarDir = vs.Item1[8],
                    Username = vs.Item1[9],
                    Home = vs.Item1[10],
                    Devel = vs.Item2[0],
                    Prov = vs.Item2[1],
                    Untar = vs.Item2[2],
                    Verify = vs.Item2[3]
                })!;
        }

        private static Input<T?> ToNullable<T>(this Input<T>? input) where T : class
            => input != null ? input.Apply(v => (T?)v) : Output.Create((T?)null);

        private static Input<bool?> ToNullable(this Input<bool>? input)
            => input != null ? input.Apply(v => (bool?)v) : Output.Create((bool?)null);
    }
}
